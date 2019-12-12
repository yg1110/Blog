package com.boot.service;

import java.util.List;

import com.boot.dto.User;

public interface IUserService {
	List<User> getUserList();
	User findUser(String email);
	void insertUser(User user);
}
