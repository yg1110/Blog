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
	public USER findUser(USER user) {
		return dao.findUser(user);
	}

	@Override
	public void insertUser(USER user) {
		dao.insertUser(user);
	}
	
}
