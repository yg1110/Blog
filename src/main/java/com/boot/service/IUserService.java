package com.boot.service;

import java.util.List;

import com.boot.dto.Auth;
import com.boot.dto.User;

public interface IUserService {
	List<User> getUserList();
	User findUser(User user);
	void insertUser(User user);
	void insertAuth(Auth auth);
	void updateUser(User user);
}
