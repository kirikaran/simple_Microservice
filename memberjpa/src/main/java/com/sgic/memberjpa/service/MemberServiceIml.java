package com.sgic.memberjpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.memberjpa.model.Member;
import com.sgic.memberjpa.repository.MemberRepository;



@Service
public class MemberServiceIml implements MemberService {
	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public Member createMember(Member member) {
		return memberRepository.save(member);
	}
	
	@Override
	public List<Member> getMembers() {
		return memberRepository.findAll();
	}

	@Override
	public Optional<Member> getMemberById(Integer id) {
		return memberRepository.findById(id);
	}

	@Override
	public void deleteMember(Integer id) {
		memberRepository.deleteById(id);
	}

	@Override
	public Member updateMember(Member member, Integer id) {
		Optional<Member> memberEntity = memberRepository.findById(id);
		Member updatedEntity = new Member();

		if (memberEntity.isPresent()) {
			updatedEntity.setId(id);
			updatedEntity.setName(member.getName());
			updatedEntity.setEmail(member.getEmail());
			return memberRepository.save(updatedEntity);

		}
		return null;
	}
}