package com.boot.service;

import java.util.List;

import com.boot.dto.User;

public interface IMemberService {
	List<User> getUserList();
	User findUser(User user);
	void insertUser(User user);
}
