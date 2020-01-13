package com.boot.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.boot.Repository.AccountRepository;
import com.boot.Repository.BoardRepository;
import com.boot.Repository.SessionRepository;
import com.boot.dto.Auth;
import com.boot.dto.User;
import com.boot.service.IUserService;

@Controller
public class UserController {
	private final Logger log = LoggerFactory.getLogger(BoardController.class);

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

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(Model model, HttpSession httpSession, @PageableDefault(sort = { "id" }, direction = Direction.DESC, size = 4) Pageable page) {
		if (httpSession.getAttribute("login") != null) {
			model.addAttribute("board", boardRepository.findAll(page));
			User user = new User();
			user.setUsername(httpSession.getAttribute("login").toString());
			model.addAttribute("user", userService.findUser(user));

			return "redirect:/list";
		} else {
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

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		return "blog/login";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model, HttpSession httpSession, @PageableDefault(sort = { "id" }, direction = Direction.DESC, size = 4) Pageable page) {
		model.addAttribute("board", boardRepository.findAll(page));
		User user = new User();
		user.setUsername(httpSession.getAttribute("login").toString());
		model.addAttribute("user", userService.findUser(user));

		return "blog/blog-list";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup() {
		return "blog/signup";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profile(Model model, HttpSession httpSession) {
		User user = new User();
		user.setUsername(httpSession.getAttribute("login").toString());
		model.addAttribute("user", userService.findUser(user));
		return "blog/blog-profile";
	}

	@RequestMapping(value = "/regi", method = RequestMethod.POST)
	public String regi(User user) throws IOException {
		log.info("user : " + user);
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

		if ((long) userService.getUserList().size() == 0) {
			user.setId((long) 1);
		} else {
			user.setId((long) userService.getUserList().size() + 1);
		}
		Auth auth = new Auth();
		auth.setAuthority_id((long) 2);
		auth.setUsuario_id((long) user.getId());
		log.info("user : " + user);
		user.setImage("../image/noprofile.png");
		userService.insertUser(user);
		userService.insertAuth(auth);
		return "redirect:/login";
	}

	@RequestMapping(value = "/pro.do", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String pro(Model model, User user, @RequestParam("file") MultipartFile file) throws IOException {
		
		if(file.isEmpty()) {
			user.setImage("../image/noprofile.png");
		}
		else {			
			File convertfile = new File("/Users/jeong-yeong-gil/Documents/stswork/Blog/src/main/resources/static/image/"
					+ file.getOriginalFilename());
			
			convertfile.createNewFile();
			
			try (FileOutputStream fout = new FileOutputStream(convertfile)) {
				fout.write(file.getBytes());
			} catch (Exception e) {
				e.printStackTrace();
			}
			user.setImage("/image/" + file.getOriginalFilename());
		}
		
		userService.updateUser(user);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/findpassword", method = RequestMethod.GET)
	public String findpasswordGET() {
		return "blog/findpassword";
	}
}