package com.kosta.helloboot.member.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.kosta.helloboot.board.vo.Board;
import com.kosta.helloboot.member.vo.Member;

@Repository
public class MemberDaoInMemory implements MemberDao {
	private Map<Long, Member> memberdMap;
	private long memberId;

	public MemberDaoInMemory() {
		this.memberdMap = new HashMap<>();
		this.memberId = 0;
	}

	@Override
	public Member insertNewMember(Member member) {
		member.setIndex(++memberId);
		this.memberdMap.put(memberId, member);

		return null;
	}

	@Override
	public Member selectOneMember(long memberId) {
		return this.memberdMap.get(memberId);
	}

	@Override
	public List<Member> selectAllMembers() {
		return this.memberdMap.entrySet().stream().map(entry -> entry.getValue()).collect(Collectors.toList());
	}

	@Override
	public void deleteOneMember(long memberId) {
		this.memberdMap.remove(memberId);
		
	}

	@Override
	public Member updateOneMember(Member member) {
		Member originalMember = this.selectOneMember(member.getIndex());

		member.setIndex(originalMember.getIndex());

		this.memberdMap.put(originalMember.getIndex(), member);
		return member;
	}

}
