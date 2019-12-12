package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.boot.dto.User;
import com.boot.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService service;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String welcome() {
		return "index";
	}

	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("user", service.getUserList());
		return "list";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(Model model, User user) {
		System.out.println("==============login==============");
		System.out.println("들어온 값 : " + user);
		User myinfo = service.findUser(user.getEmail());
		if(myinfo == null || !(myinfo.getPwd().equals(user.getPwd()))) {		
			return "index";
		}
		else {
			if(myinfo.getEmail().equals("aaa")) {
				return "DashBoard";
			}
			else {				
				return "main";
			}
		}
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signup() {
		return "signup";
	}
	
	@RequestMapping(value="/regi", method=RequestMethod.POST)
	public String regi(Model model, User user) {
		System.out.println("==============regi==============");
		System.out.println("들어온 값 : " + user);
		service.insertUser(user);
		return "redirect:/";
	}
}