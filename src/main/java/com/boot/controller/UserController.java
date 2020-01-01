package com.boot.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.boot.Repository.AccountRepository;
import com.boot.Repository.SessionRepository;
import com.boot.dto.Auth;
import com.boot.dto.User;
import com.boot.service.IUserService;

@Controller
public class UserController {
	@Autowired
	IUserService userService;

	@Autowired
	SessionRepository repository;
	
	@Autowired
	StringRedisTemplate reidstemplate;
		
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String welcome(Model model, HttpSession httpSession) {
		

//		Optional<User> isLogin = repository.findById(httpSession.toString()); //세션확인
		
//		if(isLogin.isEmpty()) {
//			return "login/index";
//		}
//		
//		if(isLogin.get().getAuthority().) { //운영자 세션정보가 있을경우
//			model.addAttribute("name", isLogin.get().getName());
//			return "blog/DashBoard";
//		}
//		else { //유저 세션정보가 있을경우
//			model.addAttribute("name", isLogin.get().getName());
//			return "blog/index";
//		}
		return "login/index";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model) {
		return "login/index";
	}

	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(Model model, Principal principal) {
		System.out.println(principal.getName());
		if(principal.getName().equals("admin")) {
			model.addAttribute("name", principal.getName());
			return "blog/DashBoard";
		}
		else {
			model.addAttribute("name", principal.getName());
			return "blog/index";
		}
	}
	

	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signup() {
		return "login/signup";
	}
	
	@RequestMapping(value="/regi", method=RequestMethod.POST)
	public String regi(Model model, User user) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
		if((long)userService.getUserList().size() == 0) {
			user.setId((long)1);
		}
		else {
			user.setId((long)userService.getUserList().size() + 1);
		}
		Auth auth = new Auth();
		auth.setAuthority_id((long)2);
		auth.setUsuario_id((long)user.getId());
		userService.insertUser(user);
		userService.insertAuth(auth);
		return "redirect:/";
	}
}