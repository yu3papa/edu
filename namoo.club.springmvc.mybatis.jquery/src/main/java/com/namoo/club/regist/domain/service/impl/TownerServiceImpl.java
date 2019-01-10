package com.namoo.club.regist.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.namoo.club.regist.domain.entity.Club;
import com.namoo.club.regist.domain.entity.Towner;
import com.namoo.club.regist.domain.service.TownerService;
import com.namoo.club.regist.domain.service.dto.TownerCDto;
import com.namoo.club.regist.mybatis.mapper.ClubMapper;
import com.namoo.club.regist.mybatis.mapper.ClubMemberMapper;
import com.namoo.club.regist.mybatis.mapper.TownerMapper;
import com.namoo.club.util.exception.NamooClubException;
import com.namoo.club.util.exception.EmptyResultException;

@Service
public class TownerServiceImpl implements TownerService {

	@Autowired
	private TownerMapper townerMapper;
	
	@Autowired
	private ClubMapper clubMapper;
	
	@Autowired
	private ClubMemberMapper clubMemberMapper;
	
	@Override
	public String registerTowner(TownerCDto townerCDto) throws NamooClubException {
		// 
		Towner towner = townerMapper.selectTownerByEmail(townerCDto.getEmail());
		
		if (towner != null) { 
			throw new NamooClubException("Email is already exist. --> " + townerCDto.getEmail());
		}
		
		towner = townerCDto.createDomain(); 
		townerMapper.insertTowner(towner);
		
		return towner.getId(); 
	}

	@Override
	public Towner findTownerByEmail(String email) throws NamooClubException {
		// 
		try {
			return townerMapper.selectTownerByEmail(email);
		}
		catch (EmptyResultException e) {
			throw new EmptyResultException("No such towner by email --> " + email);
		}
	}

	@Override
	public Towner findTowner(String townerId) throws NamooClubException {
		// 
		try {
			return townerMapper.selectTowner(townerId);
		}
		catch (EmptyResultException e) {
			throw new EmptyResultException("No such towner by id --> " + townerId);
		}
	}

	@Override
	public void modifyTowner(Towner towner) {
		// 
		townerMapper.updateTowner(towner);
	}

	@Override
	public void removeTowner(String townerId) throws NamooClubException {
		// 
		Towner towner = null;
		try {
			towner = townerMapper.selectTowner(townerId);
		} catch (EmptyResultException e) {
			throw new NamooClubException(e);
		}
		
		String email = towner.getEmail();
		
		// 커뮤니티의 회원으로 가입된 경우 삭제하지 못한다.
		List<Club> joinedClub = clubMemberMapper.selectJoinedClub(email);
		if (joinedClub != null && !joinedClub.isEmpty()) {
			int count = joinedClub.size();
			throw new NamooClubException("Please withdrawal from [" + count + "] clubs");
		}
		
		townerMapper.deleteTowner(towner.getId());
	}

	@Override
	public void removeTownerByEmail(String email) throws NamooClubException {
		// 
		// 커뮤니티의 회원으로 가입된 경우 삭제하지 못한다.
		List<Club> joinedClub = clubMemberMapper.selectJoinedClub(email);
		if (joinedClub != null && !joinedClub.isEmpty()) {
			int count = joinedClub.size();
			throw new NamooClubException("Please withdrawal from [" + count + "] clubs");
		}
		
		Towner towner = null;
		try {
			towner = townerMapper.selectTownerByEmail(email); 
		}
		catch (EmptyResultException e) {
			throw new NamooClubException(e);
		}
		
		if (towner == null) {
			return; 
		}
		
		townerMapper.deleteTowner(towner.getId());
	}

	@Override
	public boolean loginAsTowner(String email, String password) throws NamooClubException {
		// 
		Towner towner = null; 
		try {
			towner = townerMapper.selectTownerByEmail(email);
		}
		catch (EmptyResultException e) {
			throw new NamooClubException(e);
		}
		
		if (towner == null) {
			return false; 
		}
		
		if (!towner.getPassword().equals(password)) {
			return false; 
		}
		
		return true;
	}
}
