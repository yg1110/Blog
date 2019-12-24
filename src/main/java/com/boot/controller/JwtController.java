package com.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JwtController {
	@GetMapping("/hello")
	public String hello() {
		return "security/hello";
	}

	@GetMapping("/index")
	public String index() {
		return "security/index";
	}

	@GetMapping("/my")
	public String my() {
		return "security/my";
	}
}
