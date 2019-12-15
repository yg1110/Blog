package com.boot;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import com.boot.Repository.SessionRepository;
import com.boot.dto.Session;

@Component
public class RedisRunner implements ApplicationRunner{

	@Autowired
	StringRedisTemplate reidstemplate;
	
	@Autowired
	SessionRepository repository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		ValueOperations<String, String> values = reidstemplate.opsForValue();
		values.set("yg", "1110");
		values.set("hello", "world");
		
		Session session = new Session();
		session.setEmail("aa@aa");
		session.setUsername("yg");
		
		repository.save(session);
		
		Optional<Session> byId = repository.findById(session.getId());
		System.out.println(byId.get().getUsername());
		System.out.println(byId.get().getId());
	}
}