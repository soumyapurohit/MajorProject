package com.pocket.controller;


import com.pocket.dao.MemberDao;
import com.pocket.dao.NetworkDao;
import com.pocket.model.Member;
import com.pocket.model.Network;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    NetworkDao networkdao;
    @Autowired
    MemberDao memberdao;
            
     @RequestMapping(value = "/network",method = RequestMethod.GET)
    public ModelAndView network()
    {
            ModelAndView mv = new ModelAndView("adminNetworks");
            List<Network> networks = networkdao.list();
            for(Network lit:networks){
                System.out.println(lit);
            }
           
             mv.addObject("networks", networks);
             return mv;
    }
    
    @RequestMapping(value = "/mynetwork",method = RequestMethod.GET)
    public ModelAndView network(int memberId)
    {
        System.out.println("memberid="+memberId);
        
        ModelAndView mv = new ModelAndView("adminNetworks");
            List<Network> networks = networkdao.lists(memberId);
            for(Network lit:networks){
                System.out.println(lit);
            }
             Member mem=memberdao.getByID(memberId);
             mem.getFname();
             mv.addObject("networks", networks);
             mv.addObject("member", mem);
             
             return mv;
    }
    
    @RequestMapping(value = "/member",method = RequestMethod.GET)
    public ModelAndView member()
    {
        ModelAndView mv = new ModelAndView("adminMember");
         
            List<Member> members = memberdao.list();
            for(Member lit:members){
                System.out.println(lit);
            }
           
             mv.addObject("members", members);
             return mv;
   
    }
}
