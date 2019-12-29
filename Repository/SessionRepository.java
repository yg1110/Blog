package com.boot.Repository;

import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.repository.CrudRepository;

import com.boot.dto.USER;

<<<<<<< HEAD:src/main/java/com/boot/Repository/SessionRepository.java
@RedisHash("User")
=======
@RedisHash("USER")
>>>>>>> 87f20bb2bbaac7d45c065a9988f74bc395f72ebd:Repository/SessionRepository.java
public interface SessionRepository extends CrudRepository<USER, String> {
	
}