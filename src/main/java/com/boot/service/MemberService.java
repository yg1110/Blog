package com.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.dao.MemberDao;
import com.boot.dto.Member;

@Service
public class MemberService implements IMemberService{
	@Autowired
	private MemberDao dao;

	@Override
	public List<Member> getMemberList() {
		return dao.getMemberList();
	}
	
	@Override
	public Member findMember(Member member) {
		return dao.findMember(member);
	}

	@Override
	public void insertMember(Member member) {
		dao.insertMember(member);
	}
	
}
