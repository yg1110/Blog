package com.boot.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.boot.dto.Member;

@Repository
public class MemberDao {
	String ns="yg1110.blog.";

	@Autowired
	private SqlSession sqlSession;
	
	public List<Member> getMemberList (){
		return sqlSession.selectList(ns+"getMemberList");
	}

	public Member findMember(Member member) {
		return sqlSession.selectOne(ns+"findMember", member);
	}

	public void insertMember(Member member) {
		sqlSession.insert(ns+"insertMember", member);
	}
}
