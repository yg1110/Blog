package com.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.dao.UserDAO;
import com.boot.dto.USER;

@Service
public class UserService implements IUserService{
	@Autowired
	private UserDAO dao;

	@Override
	public List<USER> getUserList() {
		return dao.getUserList();
	}
	
	@Override
<<<<<<< HEAD:src/main/java/com/boot/service/UserService.java
	public USER findUser(String email) {
		return dao.findUser(email);
=======
	public USER findUser(USER user) {
		return dao.findUser(user);
>>>>>>> 87f20bb2bbaac7d45c065a9988f74bc395f72ebd:service/UserService.java
	}

	@Override
	public void insertUser(USER user) {
		dao.insertUser(user);
	}
	
}
