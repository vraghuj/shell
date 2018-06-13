package com.saven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.saven.model.User;
import com.saven.service.UserService;

@Controller
public class BaseController {
	
	@Autowired
	private UserService userService;

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView dashboard() {
    	ModelAndView model = new ModelAndView();
    	//model.addObject("users", getUsers());
    	model.setViewName("dashboard");
    	return model;
    }
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView viewHomePage() {
    	ModelAndView model = new ModelAndView();
    	//User user = userService.getUserById("s");
    	model.setViewName("index");
    	return model;
    }

}
