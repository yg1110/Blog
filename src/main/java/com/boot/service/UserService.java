package com.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.dao.UserDAO;
import com.boot.dto.User;

@Service
public class UserService implements IUserService{
	@Autowired
	private UserDAO dao;

	@Override
	public List<User> getUserList() {
		return dao.getUserList();
	}
	
	@Override
	public User findUser(String email) {
		return dao.findUser(email);
	}

	@Override
	public void insertUser(User user) {
		dao.insertUser(user);
	}
	
}
