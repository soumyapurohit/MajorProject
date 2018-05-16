package com.pocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/homedesk")
public class HomeController 
{
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public ModelAndView home()
    {
        ModelAndView mv = new ModelAndView("home");
        return mv;
    }
    
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public ModelAndView register()
    {
        ModelAndView mv = new ModelAndView("register");
        return mv;
    }
    
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView login()
    {
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }
}
