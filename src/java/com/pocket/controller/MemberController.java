package com.pocket.controller;

import com.pocket.dao.InvitationDao;
import com.pocket.dao.MemberDao;
import com.pocket.dao.MemberProfDao;
import com.pocket.dao.MemberQualiDao;
import com.pocket.dao.NetworkDao;
import com.pocket.dao.NetworkMemberDao;
import com.pocket.dao.UserDao;
import com.pocket.model.Invitation;
import com.pocket.model.Member;
import com.pocket.model.MemberProfession;
import com.pocket.model.MemberQualification;
import com.pocket.model.Network;
import com.pocket.model.NetworkMember;
import com.pocket.model.User;
import com.pocket.modelweb.NetworkInvitation;
import com.pocket.util.EmailUtil;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.pocket.util.PocketConstant;
import com.pocket.util.MediaUpload;
import java.io.File;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;
import com.pocket.util.PocketConstant;
import java.util.Random;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/member")
public class MemberController {

    @Autowired // ByType
    MemberDao memberDao;

    @Autowired
    UserDao userDao;

    @Autowired
    NetworkDao networkDao;

    @Autowired
    MemberQualiDao qualificationDao;

    @Autowired
    MemberProfDao professionDao;

    @Autowired
    InvitationDao inviteDao;

    @Autowired
    NetworkMemberDao networkMemberDao;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView homeMember(HttpServletRequest request) {
        HttpSession sess = request.getSession();
        
       
                
        if (sess.getAttribute("user_type").toString().equals("member")) {
            ModelAndView mv = new ModelAndView("member");
            Member mem = (Member) sess.getAttribute("member");

            List<Network> networks = networkDao.list(mem.getMemberId(), true);
            mv.addObject("networks", networks);

            List<NetworkInvitation> details = inviteDao.inviteList(mem.getMemberId());
            mv.addObject("details", details);
            

            List<Network> joined = networkDao.joinedNetwork(mem.getMemberId());
            for (Network join : joined) {
                System.out.println("joined ..." + join);
            }

            mv.addObject("joined", joined);

            System.out.println("INCCCCCCCCCCCCCCC Size : " + details.size());
            return mv;
        } else {
            ModelAndView mv = new ModelAndView("admin");
            return mv;
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logoutMember(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return new ModelAndView("home");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView loginMember(String email, String password, HttpServletRequest request) {

        User user = userDao.login(email, password);

        if (user == null) {
            ModelAndView mv = new ModelAndView("error");
            mv.addObject("msg", PocketConstant.LOGIN_MSG);
            return mv;
        } else {
            int memID = user.getMemberId();
            Member member = memberDao.getByID(memID);

            if (user.getUser_active() == false) {
                ModelAndView mv = new ModelAndView("success");
                mv.addObject("uid", user.getUser_id());
                mv.addObject("mid", member.getMemberId());
                return mv;
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("user_id", user.getUser_id());
                session.setAttribute("user_type", user.getUser_Type());

                session.setAttribute("member", member);
                System.err.println("LOgin MEM : " + member);

                if (user.getUser_Type().equals("member")) {
                    ModelAndView mv = new ModelAndView("member");

                    List<Network> networks = networkDao.list(memID, true);
                    mv.addObject("networks", networks);

                    List<NetworkInvitation> details = inviteDao.inviteList(memID);
                    mv.addObject("details", details);

                    List<Network> joined = networkDao.joinedNetwork(memID);
                    mv.addObject("joined", joined);

                    return mv;
                } else {
                    ModelAndView mv = new ModelAndView("admin");
                    return mv;
                }
            }
        }

    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveMember(String password, Member member, HttpServletRequest request) {
        System.out.println("MEM : " + member);
        System.out.println("Pass: " + password);
        ModelAndView mv = new ModelAndView("error");

        int mid = memberDao.save(member);

        if (mid == -1) {
            mv.addObject("msg", PocketConstant.REGISTER_MSG);
            return mv;
        } else {
            User user = new User(0, 0, mid, "member", member.getEmail(), password, false);
            int uid = userDao.save(user);
            if (uid > 0) {
                MediaUpload.createMemberFolder(request.getServletContext().getRealPath("/"), mid);

                Random r = new Random(System.currentTimeMillis());
                int otp = 10000 + r.nextInt(20000);
                String msg = "<font color='#4cb1ca'>Thank you for your interest in Pocketdesk."
                        + "<br> We just need to confirm that you made this request."
                        + "So, we have sent you an OTP : </font>" + otp;

                EmailUtil.sendEmail(member.getEmail(), "PocketDesk OTP Verification", msg);

                user.setOtp(otp);
                userDao.update(user);

                ModelAndView mv1 = new ModelAndView("success");
                mv1.addObject("uid", uid);
                mv1.addObject("mid", mid);
                return mv1;
            } else {
                mv.addObject("msg", PocketConstant.REGISTER_MSG);
                return mv;
            }
        }

    }

    @RequestMapping(value = "/uploadPost", method = RequestMethod.GET)
    public ModelAndView uploadPost() {
        ModelAndView mv = new ModelAndView("uploadPostinclude");
        return mv;
    }

    @RequestMapping(value = "/chat", method = RequestMethod.GET)
    public ModelAndView chat() {
        ModelAndView mv = new ModelAndView("ChatBox");
        return mv;
    }

    @RequestMapping(value = "/createNw", method = RequestMethod.GET)
    public ModelAndView createNw() {
        ModelAndView mv = new ModelAndView("createNWinclude");
        return mv;
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView profile(HttpServletRequest request) {
        HttpSession sess = request.getSession();
        Member mem = (Member) sess.getAttribute("member");

        ModelAndView mv = new ModelAndView("profile");
        mv.addObject("member", mem);

        MemberQualification memQualification = qualificationDao.getByMember(mem.getMemberId());
        mv.addObject("qualification", memQualification);
        MemberProfession memProfession = professionDao.getByMember(mem.getMemberId());
        mv.addObject("profession", memProfession);
        System.err.println("PP MEM : " + mem);

        return mv;
    }

    @RequestMapping(value = "/profilesave", method = RequestMethod.POST)
    public ModelAndView profileSave(@ModelAttribute Member member,
            BindingResult br,
            MultipartFile profileImage,
            HttpServletRequest request) {
        System.out.println("Update MEM : " + member);

        HttpSession sess = request.getSession();
        Member mem = (Member) sess.getAttribute("member");

        String p = request.getServletContext().getRealPath("/");

        MediaUpload upload = new MediaUpload(profileImage, member, null);
        String fileName = upload.uploadProfilePic(p);
        if (fileName != null) {
            member.setProfilePic(fileName);
        } else {
            member.setProfilePic(mem.getProfilePic());
        }

        boolean check = memberDao.update(member);
        if (check) {
            sess.setAttribute("member", member);

            ModelAndView mv = new ModelAndView("profile");
            mv.addObject("member", member);

            MemberQualification memQualification = qualificationDao.getByMember(member.getMemberId());
            mv.addObject("qualification", memQualification);

            MemberProfession memProfession = professionDao.getByMember(member.getMemberId());
            mv.addObject("profession", memProfession);
            return mv;
        } else {
            ModelAndView mv1 = new ModelAndView("error");
            return mv1;
        }
    }

    @RequestMapping(value = "/passSave", method = RequestMethod.POST)
    public ModelAndView passSave(HttpServletRequest request, String oldPass, String newPass) {
        HttpSession sess = request.getSession();
        Member mem = (Member) sess.getAttribute("member");

        ModelAndView mv = new ModelAndView("profile");
        mv.addObject("member", mem);

        userDao.updatePass(mem.getMemberId(), oldPass, newPass);
        return mv;
    }

    @RequestMapping(value = "/getName", method = RequestMethod.GET)
    @ResponseBody
    public String getName(int memberId) {
        Member mem = memberDao.getByID(memberId);
        return mem.getFname() + " " + mem.getLname();
    }

    @RequestMapping(value = "/checkemail", method = RequestMethod.GET)
    @ResponseBody
    public String checkemail(String email) {
        return memberDao.checkemail(email) + "";
    }
}
