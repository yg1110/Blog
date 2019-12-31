package com.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.boot.dto.Member;
import com.boot.service.UserService;

@Component
public class AccountRunner implements ApplicationRunner{
	@Autowired
	UserService userservice;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Member member = new Member();
		member.setId("yg1110");
		member.setPwd("1234");
		member.setName("yg");
		member.setAuth("ROLE_USER");
		userservice.createAccount(member);
		System.out.println("생성완료");
	}
	
}
