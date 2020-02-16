package com.sgic.memberjpa.service;

import java.util.List;
import java.util.Optional;

import com.sgic.memberjpa.model.Member;

public interface MemberService {

	Member createMember(Member member);

	List<Member> getMembers();

	Optional<Member> getMemberById(Integer id);

	void deleteMember(Integer id);

	Member updateMember(Member member, Integer id);

}