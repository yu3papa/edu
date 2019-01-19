package com.kosta.helloboot.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.helloboot.board.vo.Board;
import com.kosta.helloboot.member.dao.MemberDao;
import com.kosta.helloboot.member.vo.Member;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired // BoardDao를 구현한 클래스를 가져와서 주입해라!!!
	private MemberDao memberDao;

	@Override
	public Member createNewMember(Member member) {
		Member newMember = this.memberDao.insertNewMember(member);
		return newMember;
	}

	@Override
	public Member findOneMember(long memberId) {
		return this.memberDao.selectOneMember(memberId);
	}

	@Override
	public List<Member> findAllMembers() {
		return this.memberDao.selectAllMembers();
	}

	@Override
	public void deleteOneMember(long memberId) {
		this.memberDao.deleteOneMember(memberId);
		
	}

	@Override
	public Member updateOneMember(Member member) {
		return this.memberDao.updateOneMember(member);
	}

}
