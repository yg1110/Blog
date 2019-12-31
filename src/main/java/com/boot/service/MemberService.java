package com.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.dao.MemberDao;
import com.boot.dto.User;

@Service
public class MemberService implements IMemberService{
	@Autowired
	private MemberDao dao;

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
	
}
