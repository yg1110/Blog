package com.boot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.Repository.UserRepository;
import com.boot.dto.Users;

@RestController
public class UserMongoController {
	private UserRepository userRepository;

    public UserMongoController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/all")
    public List<Users> getAll() {
        return userRepository.findAll();
    }
}
