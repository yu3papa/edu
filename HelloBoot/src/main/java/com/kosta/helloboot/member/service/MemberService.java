package com.kosta.helloboot.member.service;

import java.util.List;

import com.kosta.helloboot.board.vo.Board;
import com.kosta.helloboot.member.vo.Member;

public interface MemberService {
	public Member createNewMember(Member member);

	public Member findOneMember(long memberId);
	
	public List<Member> findAllMembers();
	
	public void deleteOneMember(long memberId);

	public Member updateOneMember(Member member);
}
