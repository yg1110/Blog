package com.boot.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.boot.dto.User;

@Repository
public class UserDAO {
	String ns="yg1110.blog.";

	@Autowired
	private SqlSession sqlSession;
	
	public List<User> getUserList (){
		return sqlSession.selectList(ns+"getUserList");
	}

	public User findUser(String email) {
		return sqlSession.selectOne(ns+"findUser", email);
	}

	public void insertUser(User user) {
		sqlSession.insert(ns+"insertUser", user);
	}
}
