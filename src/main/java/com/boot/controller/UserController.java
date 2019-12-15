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
import com.boot.dto.User;
import com.boot.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService service;

	@Autowired
	SessionRepository repository;
	
	@Autowired
	StringRedisTemplate reidstemplate;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String welcome(Model model, HttpSession httpSession) {
		Optional<User> isLogin = repository.findById(httpSession.toString()); //세션확인
		System.out.println(isLogin);
		
		if(isLogin.isEmpty()) {
			return "login/index";
		}
		
		if(isLogin.get().getAuth() == 1) { //운영자 세션정보가 있을경우
			model.addAttribute("name", isLogin.get().getPwd());
			return "blog/DashBoard";
		}
		else { //유저 세션정보가 있을경우
			model.addAttribute("name", isLogin.get().getPwd());
			return "blog/index";
		}
	}

	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("user", service.getUserList());
		return "list";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession httpSession) {
		repository.deleteById(httpSession.toString());
		return "redirect:/";
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(Model model, User user, HttpSession httpSession) {
		System.out.println("==============login==============");
		
		User myinfo = service.findUser(user.getEmail());
		System.out.println(myinfo);
		if(myinfo == null || !(myinfo.getPwd().equals(user.getPwd()))) { //로그인실패
			return "login/index";
		}
		else {
			//레디스에 pwd에 현재 아이디를넣고 email 세션아이디를 넣고 키로씁니다.
			if(myinfo.getAuth()==1) { //운영자 페이지
				myinfo.setPwd(myinfo.getEmail());
				myinfo.setEmail(httpSession.toString());
				model.addAttribute("name", myinfo.getPwd());

				repository.save(myinfo);
				return "blog/DashBoard";
			}
			else { //유저페이지
				myinfo.setPwd(myinfo.getEmail());
				myinfo.setEmail(httpSession.toString());
				model.addAttribute("name", myinfo.getPwd());

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
	public String regi(Model model, User user) {
		System.out.println("==============regi==============");
		System.out.println("들어온 값 : " + user);
		service.insertUser(user);
		return "redirect:/";
	}
}