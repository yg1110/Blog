package com.boot.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.boot.dto.Users;

public interface UserRepository extends MongoRepository<Users, Integer> {
}