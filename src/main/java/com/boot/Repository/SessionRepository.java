package com.boot.Repository;

import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.repository.CrudRepository;

import com.boot.dto.Member;

@RedisHash("User")
public interface SessionRepository extends CrudRepository<Member, String> {
	
}