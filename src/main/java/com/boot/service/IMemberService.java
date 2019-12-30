package com.boot.service;

import java.util.List;

import com.boot.dto.Member;

public interface IMemberService {
	List<Member> getMemberList();
	Member findMember(Member member);
	void insertMember(Member member);
}
