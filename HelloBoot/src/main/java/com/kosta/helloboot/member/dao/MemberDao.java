package com.kosta.helloboot.member.dao;

import java.util.List;

import com.kosta.helloboot.board.vo.Board;
import com.kosta.helloboot.member.vo.Member;

public interface MemberDao {
	public Member insertNewMember(Member member);
	
	public Member selectOneMember(long memberId);
	
	public List<Member> selectAllMembers();
	
	public void deleteOneMember(long memberId);

	public Member updateOneMember(Member member);
}
