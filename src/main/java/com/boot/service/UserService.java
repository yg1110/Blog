package com.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.dao.UserDao;
import com.boot.dto.Auth;
import com.boot.dto.User;

@Service
public class UserService implements IUserService{
	
	@Autowired
	private UserDao dao;

	@Override
	public List<User> getUserList() {
		return dao.getUserList();
	}
	
	@Override
	public User findUser(User user) {
		return dao.findUser(user);
	}

	@Override
	public void insertUser(User user) {
		dao.insertUser(user);
	}

	@Override
	public void insertAuth(Auth auth) {
		dao.insertAuth(auth);
	}

	@Override
	public void updateUser(User user) {
		dao.updateUser(user);
	}

	@Override
	public User findpassword(User user) {
		return dao.findpassword(user);
	}

	@Override
	public void updatepassword(User user) {
		dao.updatepassword(user);
	}
}
