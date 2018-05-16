/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pocket.controller;

import com.pocket.dao.MemberProfDao;
import com.pocket.model.Member;
import com.pocket.model.MemberProfession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/Profession")
public class ProfessionController {
 
    
    @Autowired
    MemberProfDao profDao;
    
   
    @RequestMapping(value = "/profilesave",method = RequestMethod.POST)
     public String profileSave(@ModelAttribute MemberProfession mprof,
                                    BindingResult br,                                   
                                    HttpServletRequest request)
    {
        System.out.println("memberProfession"+mprof);
        boolean check=profDao.saveOrUpdate(mprof);
        if(check)
        {
            return "redirect:/member/profile";
        }
        else{
            return "error";
        }
        
}
}