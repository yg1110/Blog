package com.boot.controller;

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
import com.boot.Repository.BoardRepository;
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
	
	@Autowired
	BoardRepository boardRepository;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String welcome(Model model, HttpSession httpSession) {
		if(httpSession.getAttribute("login")!=null) {
//			System.out.println(httpSession.getAttribute("login"));
			model.addAttribute("board", boardRepository.findAll());
			return "blog/blog-list";
		}
		else {
			return "blog/login";
		}

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
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model) {
		return "blog/login";
	}

	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("board", boardRepository.findAll());
		return "blog/blog-list";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signup() {
		return "blog'/signup";
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