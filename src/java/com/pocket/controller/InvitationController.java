/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pocket.controller;

import com.pocket.dao.InvitationDao;
import com.pocket.dao.MemberDao;
import com.pocket.dao.NetworkDao;
import com.pocket.dao.NetworkMemberDao;
import com.pocket.model.Invitation;
import com.pocket.model.Member;
import com.pocket.model.Network;
import com.pocket.model.NetworkMember;
import com.pocket.modelweb.NetworkInvitation;
import com.pocket.util.MediaUpload;
import com.pocket.util.PocketConstant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author hp
 */
@Controller
@RequestMapping(value = "/invite")
public class InvitationController {

    @Autowired
    NetworkDao networkDao;

    @Autowired
    MemberDao memberDao;

    @Autowired
    InvitationDao inviteDao;
    
     @Autowired
     NetworkMemberDao networkMemDao;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addMember(@RequestParam(value = "members[]") List<Integer> members, int networkId, HttpServletRequest request)
    {
        List<Member> list = new ArrayList<>();
        System.out.println("inviteee");
      
        HttpSession session = request.getSession();
        Member mem = (Member) session.getAttribute("member");
        int mem2 = (mem.getMemberId());

        for (Integer obj : members) {

            // Integer memId=Integer.parseInt(String.valueOf(obj));
            Invitation invite = new Invitation(0, networkId, obj, mem2, new Date(), "pending");
            System.out.println("invite object" + invite);
            inviteDao.save(invite);

        }

        for (Integer memb : members) {
            System.out.println("Id of member" + memb);
        }
        ModelAndView mv = new ModelAndView("setting");
        Network network = networkDao.getByID(networkId);
        mv.addObject("network", network);
        return mv;

    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    @ResponseBody
    public String showMember(int networkId, int memberId, HttpServletRequest request) 
    {    
        boolean check = inviteDao.isInvite(memberId, networkId);
        System.out.println("Net : " + networkId + " Member : " + memberId + " Res : " + check);
        return check+"";
    }
    
     @RequestMapping(value = "/accept", method = RequestMethod.GET)
     public String accept(int inviteId,HttpServletRequest request) 
     {
        HttpSession session = request.getSession();
        Member mem = (Member) session.getAttribute("member");
        
        Invitation obj = inviteDao.getByID(inviteId);
        obj.setInviteStatus(PocketConstant.INVITE_ACCEPT);
        inviteDao.update(obj);
     
        NetworkMember net= new NetworkMember(inviteId,obj.getNetworkId(),mem.getMemberId(),new Date(), true, "member");
        int nid = networkMemDao.save(net);
       
        if (nid > 0) 
        {
            MediaUpload.createJoinNetworkFolder(request.getServletContext().getRealPath("/"), obj.getNetworkId() ,mem.getMemberId());
            return "redirect:/member/home";
        } 
        else
        {
           // map.addAttribute("msg", PocketConstant.JOINED_NETWORK_MSG);
            return "error";
        }      
    }
    
        @RequestMapping(value = "/reject", method = RequestMethod.GET)
     public String reject( int inviteId,HttpServletRequest request) 
    {    
      Invitation obj=inviteDao.getByID(inviteId);
      obj.setInviteStatus(PocketConstant.INVITE_REJECT);
      inviteDao.update(obj);
      return "redirect:/member/home";
    }
    
     
    
}
