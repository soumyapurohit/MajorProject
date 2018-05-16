/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pocket.controller;

import com.pocket.dao.MemberQualiDao;
import com.pocket.model.Member;
import com.pocket.model.MemberQualification;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/Qualification")
public class QualificationController {
    
    @Autowired
    MemberQualiDao memberqu;
    
   
    
    @RequestMapping(value = "/profilesave",method = RequestMethod.POST)
     public String profileSave(@ModelAttribute Member member,
                                    MemberQualification mqu,
                                    BindingResult br, 
                                    
                                    HttpServletRequest request)
    {
        System.out.println("memberQualification"+mqu);
        boolean check=memberqu.saveOrUpdate(mqu);
        if(check)
        {
            return "redirect:/member/profile";
        }
        else{
            return "error";
        }
        
                
        
        
        
       
    }
    
    
    
}
