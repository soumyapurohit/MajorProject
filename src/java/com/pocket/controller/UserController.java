package com.pocket.controller;

import com.pocket.dao.MemberDao;
import com.pocket.dao.UserDao;
import com.pocket.model.Member;
import com.pocket.model.User;
import com.pocket.util.EmailUtil;
import com.pocket.util.MediaUpload;
import com.pocket.util.PocketConstant;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserDao userDao;
    
    @Autowired // ByType
    MemberDao memberDao;

    @RequestMapping(value = "/otpVerify", method = RequestMethod.POST)
    public String otpVerify(int otp, int userId) {
        
        User user = userDao.getByID(userId);
        int dbOtp = user.getOtp();
        if (dbOtp == otp) {
            user.setUser_active(true);
            userDao.update(user);
            return "redirect:/homedesk/login";
        } else {
            return "otpError";
        }
    }
     @RequestMapping(value = "/resend", method = RequestMethod.GET)
     @ResponseBody
     public String resend(int userId,int memberId) {
       
         System.out.println("resend method");
              
         User user = userDao.getByID(userId);
         Member member=memberDao.getByID(memberId);
       
            
           
            

                Random r = new Random(System.currentTimeMillis());
                int otp = 10000 + r.nextInt(20000);
                String msg = "<font color='#4cb1ca'>Thank you for your interest in Pocketdesk."
                        + "<br> We just need to confirm that you made this request."
                        + "So, we have sent you an OTP : </font>" + otp;

                EmailUtil.sendEmail(member.getEmail(), "PocketDesk OTP Verification", msg);

                user.setOtp(otp);
               boolean check= userDao.update(user);

                
               
                return check+"";
          
        }

    }


