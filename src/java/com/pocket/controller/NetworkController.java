/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pocket.controller;

import com.pocket.dao.MemberDao;
import com.pocket.dao.NetworkDao;
import com.pocket.dao.NetworkMemberDao;
import com.pocket.model.Member;
import com.pocket.model.Network;
import com.pocket.model.NetworkMember;
import com.pocket.util.EmailUtil;
import com.pocket.util.PocketConstant;
import com.pocket.util.MediaUpload;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.pocket.util.PocketConstant;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/network")
public class NetworkController {

    @Autowired
    NetworkDao networkDao;

    @Autowired
    MemberDao memberDao;
    
    @Autowired
    NetworkMemberDao networkmemberDao;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveNetwork(Network network1, String name, HttpServletRequest request, ModelMap map) {
        System.out.println("network" + network1);
        System.out.println("name" + name);

        HttpSession session = request.getSession();
        Member mem = (Member) session.getAttribute("member");

        Network network = new Network(0, new Date(), network1.getNetworkType(), network1.getTitle(), network1.getProfilePic(), true, false, mem.getMemberId());
        System.out.println("network after member_id" + network);
        int nid = networkDao.save(network);
        System.out.println(nid);
        NetworkMember networkMem = new NetworkMember(0, nid, mem.getMemberId(), new Date(), true, "Admin");
        int mid = networkmemberDao.save(networkMem);
        
        if(mid>0)
            System.out.println("SUCCESS >>>>>> network Member added");
        else
            System.out.println("ERROR >>>>> network Member not added");
        
        if (nid > 0) 
        {
            MediaUpload.createNetworkFolder(request.getServletContext().getRealPath("/"), network.getMemberId(), nid);
            return "redirect:/member/home";
        } 
        else
        {
            map.addAttribute("msg", PocketConstant.NETWORK_MSG);
            return "error";
        }               
    }

    @RequestMapping(value = "/setting", method = RequestMethod.GET)
    public ModelAndView settingNetwork(int networkID) 
    {
        ModelAndView mv = new ModelAndView("setting");
        Network network = networkDao.getByID(networkID);
        mv.addObject("network", network);
        
            List<Member> member = memberDao.listByNetwork(networkID);
            for(Member lit:member){
                System.out.println("<<<<<<network members ki list>>>>>>");
                System.out.println(lit);
            }
           
             mv.addObject("net_members", member);
             return mv;
    }
    
     @RequestMapping(value = "/joinedSetting", method = RequestMethod.GET)
    public ModelAndView joinedSetting(int networkID) 
    {
        System.out.println("in method joinedSetting");
               
        ModelAndView mv = new ModelAndView("joinedSetting");
        Network network = networkDao.getByID(networkID);
        mv.addObject("network", network);
        
            List<Member> member = memberDao.listByNetwork(networkID);
            for(Member lit:member){
                System.out.println("<<<<<<network members ki list>>>>>>");
                System.out.println(lit);
            }
           
            
            
             mv.addObject("net_members", member);
             return mv;
    }
    
    

    @RequestMapping(value = "/addmember", method = RequestMethod.POST)
    public ModelAndView addMember(int networkId, HttpServletRequest request) {
        System.out.println("in method add member");
        ModelAndView mv = new ModelAndView("setting");
        HttpSession session = request.getSession();
        Member mem = (Member) session.getAttribute("member");
        List<Member> members = memberDao.list(mem.getMemberId(), networkId);

        Network network = networkDao.getByID(networkId);
        mv.addObject("network", network);

        mv.addObject("members", members);
        return mv;

    }

    @RequestMapping(value = "/networkIcon", method = RequestMethod.POST)
    public String networkIcon(int networkId, MultipartFile networkPic,
            HttpServletRequest request) {
        System.out.println("Network ID >>>>>>" + networkId);
        Member member = (Member) request.getSession().getAttribute("member");
        String p = request.getServletContext().getRealPath("/");

        MediaUpload upload = new MediaUpload(networkPic, member, new Integer(networkId));
        String fileName = upload.uploadNetworkPic(p);
        System.out.println("Upload Network FileName : " + fileName);
        Network network = networkDao.getByID(networkId);
        if (fileName != null) {
            network.setProfilePic(fileName);
            boolean check = networkDao.update(network);
        } else {
            network.setProfilePic(network.getProfilePic());
        }

        return "redirect:/network/setting?networkID=" + networkId;
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String leaveNetwork(int networkId, HttpServletRequest request) {
        System.out.println("in method leave network");
        ModelAndView mv = new ModelAndView("setting");
        HttpSession session = request.getSession();
        Member mem = (Member) session.getAttribute("member");
       
       NetworkMember netmem= networkmemberDao.getByMemberNetworkId(mem.getMemberId(), networkId);
       int netmemId=netmem.getNetworkMemberId();
       netmem.setIsActive(false);
       networkmemberDao.update(netmem);
       
       Network net=networkDao.getByID(networkId);
       int memberId=net.getMemberId();
      Member member= memberDao.getByID(memberId);
       
       EmailUtil.sendEmail((member.getEmail()), " A member left from your group ", " "+ mem.getFname()+" "+ mem.getLname()+ " left from "+ net.getTitle());
       
         return "redirect:/member/home";
       
    }
     @RequestMapping(value = "/createAdmin", method = RequestMethod.GET)
    @ResponseBody
    public String createAdmin(int networkId, int memberId,
            HttpServletRequest request) {
        System.out.println("In method createAdmin");
        //Member member = (Member) request.getSession().getAttribute("member");
     NetworkMember netmem= networkmemberDao.getByMemberNetworkId(memberId, networkId);
     netmem.setNetworkMemberType("Admin");
     boolean check=networkmemberDao.update(netmem);
        

      return check+"";
       // return "redirect:/network/setting?networkID=" + networkId;
    }
    
}
