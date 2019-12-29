package com.boot.service;

import java.util.List;

import com.boot.dto.USER;

public interface IUserService {
	List<USER> getUserList();
	USER findUser(USER user);
	void insertUser(USER user);
}
