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

<<<<<<< HEAD:src/main/java/com/boot/dao/UserDAO.java
	public USER findUser(String email) {
		return sqlSession.selectOne(ns+"findUser", email);
=======
	public USER findUser(USER user) {
		return sqlSession.selectOne(ns+"findUser", user);
>>>>>>> 87f20bb2bbaac7d45c065a9988f74bc395f72ebd:dao/UserDAO.java
	}

	public void insertUser(USER user) {
		sqlSession.insert(ns+"insertUser", user);
	}
}
