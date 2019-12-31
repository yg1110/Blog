package com.boot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.boot.Repository.SessionRepository;
import com.boot.Repository.UserRepository;
import com.boot.dto.Authority;
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
		
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;


	@RequestMapping(value="/", method=RequestMethod.GET)
	public String welcome(Model model, HttpSession httpSession) {
//		Member user = userRepository.findById("user").orElseThrow(() -> new UsernameNotFoundException("No existe usuario"));
//		for (Authority authority : user.getAuth()) {
//			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getAuth());
//			System.out.println(grantedAuthority);
//		}

//		Optional<Member> isLogin = repository.findById(httpSession.toString()); //세션확인
//		
//		if(isLogin.isEmpty()) {
//			return "login/index";
//		}
//		
//		if(isLogin.get().getAuth().equals("ROLE_ADMIN")) { //운영자 세션정보가 있을경우
//			model.addAttribute("name", isLogin.get().getName());
//			return "blog/DashBoard";
//		}
//		else { //유저 세션정보가 있을경우
//			model.addAttribute("name", isLogin.get().getName());
//			return "blog/index";
//		}
		return "index";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model) {
		return "login";
	}

	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(Model model) {
		return "list";
	}
	
	@RequestMapping(value="/fail", method=RequestMethod.GET)
	public String fail(Model model) {
		return "fail";
	}
	
//	@RequestMapping(value="/logout", method=RequestMethod.GET)
//	public String logout(HttpSession httpSession) {
//		repository.deleteById(httpSession.toString());
//		return "redirect:/";
//	}
//	
//	@RequestMapping(value="/login", method=RequestMethod.POST)
//	public String login(Model model, Member member, HttpSession httpSession) {
//		System.out.println("ddd");
//		Member myinfo = service.findMember(member);
//		System.out.println(myinfo);
//		if(myinfo == null) { //로그인실패
//			return "login/index";
//		}
//		else {
//			if(myinfo.getAuth().equals("ROLE_ADMIN")) { //운영자 페이지
//				myinfo.setId(httpSession.toString());
//				model.addAttribute("name", myinfo.getName());
//				repository.save(myinfo);
//				return "blog/DashBoard";
//			}
//			else { //유저페이지
//				myinfo.setId(httpSession.toString());
//				model.addAttribute("name", myinfo.getName());
//				repository.save(myinfo);
//				return "blog/index";
//			}
//		}
//	}
//	
//	@RequestMapping(value="/login", method=RequestMethod.GET)
//	public String log() {
//		return "login/index";
//	}
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signup() {
		return "signup";
	}
	
	@RequestMapping(value="/regi", method=RequestMethod.POST)
	public String regi(Model model, Member member) {
		member.setPwd(passwordEncoder.encode(member.getPwd()));
		
		System.out.println(member);
		service.insertMember(member);
		return "redirect:/";
	}
}