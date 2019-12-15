package com.boot.controller;

import javax.servlet.http.HttpSession;

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
		return "login/index";
	}

	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("user", service.getUserList());
		return "list";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(Model model, User user, HttpSession session) {
		System.out.println("==============login==============");
		
		User myinfo = service.findUser(user.getEmail());
		System.out.println(myinfo);
		if(myinfo == null || !(myinfo.getPwd().equals(user.getPwd()))) { //로그인실패
			return "login/index";
		}
		else {
			if(myinfo.getAuth()==1) { //운영자 페이지
				session.setAttribute("login", myinfo.getAuth());
				return "blog/DashBoard";
			}
			else { //유저페이지
				session.setAttribute("login", myinfo.getAuth());
				return "blog/index";
			}
		}
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signup() {
		return "login/signup";
	}
	
	@RequestMapping(value="/regi", method=RequestMethod.POST)
	public String regi(Model model, User user) {
		System.out.println("==============regi==============");
		System.out.println("들어온 값 : " + user);
		service.insertUser(user);
		return "redirect:/";
	}
}