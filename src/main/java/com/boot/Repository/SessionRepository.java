package com.boot.Repository;

import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.repository.CrudRepository;

import com.boot.dto.USER;

@RedisHash("USER")
public interface SessionRepository extends CrudRepository<USER, String> {
	
}