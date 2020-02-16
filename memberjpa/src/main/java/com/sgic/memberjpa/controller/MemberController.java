package com.sgic.memberjpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.memberjpa.model.Member;
import com.sgic.memberjpa.service.MemberService;



@RestController
@RequestMapping("/member_service")
public class MemberController {
	
	@Autowired
	private MemberService memberService;

	@PostMapping("/member")
	public Member addMember(@RequestBody Member member) {
		return memberService.createMember(member);
	}

	@GetMapping("/members")
	public List<Member> getMembers() {
		return memberService.getMembers();
	}

	@GetMapping("/member/{memberId}")
	public Optional<Member> getMember(@PathVariable(value = "memberId") Integer id) {
		return memberService.getMemberById(id);
	}

	@PutMapping("/member/{memberId}")
	public Member updateMemberRecord(@RequestBody Member member, @PathVariable("memberId") Integer id) {
		return memberService.updateMember(member, id);
	}

	@DeleteMapping("/member/{memberId}")
	public void removeMemberRecord(@PathVariable(value = "memberId") Integer id) {
		memberService.deleteMember(id);
	}

}
