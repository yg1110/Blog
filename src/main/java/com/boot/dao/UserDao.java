package com.boot.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.boot.dto.Auth;
import com.boot.dto.User;

@Repository
public class UserDao {
	String ns="yg1110.blog.";

	@Autowired
	private SqlSession sqlSession;
	
	public List<User> getUserList (){
		return sqlSession.selectList(ns+"getUserList");
	}

	public User findUser(User user) {
		return sqlSession.selectOne(ns+"findUser", user);
	}

	public void insertUser(User user) {
		sqlSession.insert(ns+"insertUser", user);
	}
	
	public void insertAuth(Auth auth) {
		sqlSession.insert(ns+"insertAuth", auth);
	}
}
