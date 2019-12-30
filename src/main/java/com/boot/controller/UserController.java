package com.boot.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.boot.Repository.SessionRepository;
import com.boot.dto.Member;
import com.boot.service.MemberService;

@Controller
public class UserController {
	@Autowired
	private MemberService service;

	@Autowired
	SessionRepository repository;
	
	@Autowired
	StringRedisTemplate reidstemplate;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String welcome(Model model, HttpSession httpSession) {
		Optional<Member> isLogin = repository.findById(httpSession.toString()); //세션확인
		
		if(isLogin.isEmpty()) {
			return "login/index";
		}
		
		if(isLogin.get().getAuth() == 1) { //운영자 세션정보가 있을경우
			model.addAttribute("name", isLogin.get().getName());
			return "blog/DashBoard";
		}
		else { //유저 세션정보가 있을경우
			model.addAttribute("name", isLogin.get().getName());
			return "blog/index";
		}
	}

	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("user", service.getMemberList());
		return "list";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession httpSession) {
		repository.deleteById(httpSession.toString());
		return "redirect:/";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(Model model, Member member, HttpSession httpSession) {
		Member myinfo = service.findMember(member);
		System.out.println(myinfo);
		if(myinfo == null) { //로그인실패
			return "login/index";
		}
		else {
			if(myinfo.getAuth()==1) { //운영자 페이지
				myinfo.setId(httpSession.toString());
				model.addAttribute("name", myinfo.getName());
				repository.save(myinfo);
				return "blog/DashBoard";
			}
			else { //유저페이지
				myinfo.setId(httpSession.toString());
				model.addAttribute("name", myinfo.getName());
				repository.save(myinfo);
				return "blog/index";
			}
		}
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signup() {
		return "login/signup";
	}
	
	@RequestMapping(value="/regi", method=RequestMethod.POST)
	public String regi(Model model, Member member) {
		service.insertMember(member);
		return "redirect:/";
	}
}