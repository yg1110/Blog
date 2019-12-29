package com.boot.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.boot.dto.USER;

@Repository
public class UserDAO {
	String ns="yg1110.blog.";

	@Autowired
	private SqlSession sqlSession;
	
	public List<USER> getUserList (){
		return sqlSession.selectList(ns+"getUserList");
	}

	public USER findUser(USER user) {
		return sqlSession.selectOne(ns+"findUser", user);
	}

	public void insertUser(USER user) {
		sqlSession.insert(ns+"insertUser", user);
	}
}
