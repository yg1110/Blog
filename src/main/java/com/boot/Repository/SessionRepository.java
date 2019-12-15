package com.boot.Repository;

import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.repository.CrudRepository;

import com.boot.dto.Session;

@RedisHash("session")
public interface SessionRepository extends CrudRepository<Session, String> {
	
}
