//package com.boot;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.stereotype.Component;
//
//import com.boot.Repository.SessionRepository;
//
//@Component
//public class RedisRunner implements ApplicationRunner{
//	
//	@Autowired
//	SessionRepository repository;
//	
//	@Override
//	public void run(ApplicationArguments args) throws Exception {
//		//서버 실행시 세션정보 모두지우기
////		repository.deleteAll();
//	}
//	
//	public static void main(String[] args) {
//		SpringApplication.run(RedisRunner.class, args);
//	}
//}