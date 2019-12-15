package com.boot.Repository;

import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.repository.CrudRepository;

import com.boot.dto.User;

@RedisHash("User")
public interface SessionRepository extends CrudRepository<User, String> {
	
}