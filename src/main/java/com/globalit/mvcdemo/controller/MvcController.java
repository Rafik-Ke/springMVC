package com.globalit.mvcdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.globalit.mvcdemo.dto.User;

@Controller
@RequestMapping("/") // whatever we put here this is the url pattern that will
						// bring index.jsp
public class MvcController {


//	@RequestMapping(value = "/", method = RequestMethod.GET)//if we provide value in the browser url we should put that value 
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="user_url_in",method = RequestMethod.GET)
	public ModelAndView userForm() {
		ModelAndView mv = new ModelAndView();
		User u = new User();
		//addObject("key = commandName in user_jsp.jsp", object)
		u.setUsername("default_user");
		mv.addObject("user1", u);
		mv.setViewName("user_jsp_out");
		return mv;
	}
	
	@RequestMapping(value="saveUser", method=RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute User user1){
		//user must be same as the name in commandName, 
		//otherwise we should put (@ModelAttribute("user" User obj)
		System.out.println(user1.getUsername());
		System.out.println(user1.getPassword());
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", user1);
		mv.setViewName("viewUser");		
		return mv;
	}
}
