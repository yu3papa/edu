package com.namoo.club.regist.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.namoo.club.regist.domain.entity.Club;
import com.namoo.club.regist.domain.entity.ClubAdmin;
import com.namoo.club.regist.domain.entity.ClubMember;
import com.namoo.club.regist.domain.entity.Towner;
import com.namoo.club.regist.domain.service.ClubService;
import com.namoo.club.regist.domain.service.dto.ClubCDto;
import com.namoo.club.regist.mybatis.mapper.ClubMapper;
import com.namoo.club.regist.mybatis.mapper.ClubMemberMapper;
import com.namoo.club.regist.mybatis.mapper.TownerMapper;
import com.namoo.club.util.exception.EmptyResultException;
import com.namoo.club.util.exception.NamooClubException;


@Service
public class ClubServiceImpl implements ClubService{
	
	@Autowired
	private TownerMapper townerMapper;
	
	@Autowired
	private ClubMapper clubMapper;
	
	@Autowired
	private ClubMemberMapper clubMemberMapper;

	@Override
	public String registerClub(ClubCDto clubCDto) throws NamooClubException {
		//
		if (this.isExistClubByName(clubCDto.getClubName()))  {
			throw new NamooClubException("Already existed club --> " + clubCDto.getClubName());
		}
		
		Towner towner = null;
		try {
			towner = townerMapper.selectTownerByEmail(clubCDto.getAdminEmail());
		}
		catch (EmptyResultException e) {
			throw new NamooClubException(e);
		}
		 
		
		Club club = clubCDto.createDomain(new ClubAdmin(towner)); 
		clubMapper.insertClub(club);
		ClubMember clubMember = new ClubMember(club, towner); 
		clubMemberMapper.insertClubMember(club.getId(), clubMember); 
		
		return club.getId();
	}

	@Override
	public List<Club> findAllClubs() {
		//
		return clubMapper.selectAllClubs();
	}

	@Override
	public Club findClub(String clubId) throws NamooClubException {
		//
		try {
			return clubMapper.selectClub(clubId);
		}
		catch (EmptyResultException e) {
			throw new EmptyResultException("Club Id --> " + clubId);
		}
	}

	@Override
	public void modifyClub(Club club) {
		// 
		clubMapper.updateClub(club);
	}

	@Override
	public void removeClub(String clubId) throws NamooClubException {
		// 
		try {
			Club club = clubMapper.selectClub(clubId); 
			clubMapper.deleteClub(club.getId());
		}
		catch (EmptyResultException e) {
			throw new NamooClubException(e);
		}
		
	}

	@Override
	public void joinAsMember(String clubId, String email) throws NamooClubException {
		// 
		Club club = null;
		Towner towner = null;
		try {
			club = clubMapper.selectClub(clubId);
			towner = townerMapper.selectTownerByEmail(email); 
		}
		catch (EmptyResultException e) {
			throw new EmptyResultException("Club Id --> " + clubId + ", Towner email --> " + email);
		}
		
		if (this.hasMember(clubId, email)) {
			return; 
		}
		
		ClubMember member = new ClubMember(club, towner); 
		clubMemberMapper.insertClubMember(clubId, member);
	}

	@Override
	public void withdrawClub(String clubId, String memberEmail) throws NamooClubException {
		// 
		try {
			Club club = clubMapper.selectClub(clubId);
			
			// 클럽 관리자는 탈퇴할 수 없다
			if (club.getAdmin().getEmail().equals(memberEmail)) {
				throw new NamooClubException("Admin can't withdraw.");
			}
		} catch (EmptyResultException e) {
			throw new NamooClubException(e);
		}
		clubMemberMapper.deleteClubMember(clubId, memberEmail);
	}

	@Override
	public ClubMember findClubMember(String clubId, String email) throws NamooClubException {
		// 
		try {
			return clubMemberMapper.selectClubMember(clubId, email); 
		}
		catch (EmptyResultException e) {
			throw new EmptyResultException("Club Id --> " + clubId + ", Towner email --> " + email);
		}
	}

	@Override
	public List<ClubMember> findAllClubMember(String clubId) throws NamooClubException {
		// 
		try {
			return clubMemberMapper.selectAllClubMember(clubId);
		}
		catch (EmptyResultException e) {
			throw new EmptyResultException("Club Id --> " + clubId);
		}
	}

	@Override
	public int countMembers(String clubId) {
		// 
		return clubMemberMapper.countMembers(clubId); 
	}

	@Override
	public List<Club> findJoinedClubs(String memberEmail) {
		// 
		return clubMemberMapper.selectJoinedClub(memberEmail);
	}

	@Override
	public List<Club> findUnjoinedClubs(String memberEmail) throws NamooClubException {
		// 
		Towner towner = townerMapper.selectTownerByEmail(memberEmail);
		if(towner == null) {
			throw new NamooClubException(memberEmail + " is not existing");
		}
		
		return clubMemberMapper.selectUnjoinedClub(memberEmail); 
	}

	@Override
	public List<Club> findManagedClubs(String adminEmail) {
		// 
		return clubMapper.selectManagedClubs(adminEmail); 
	}

	@Override
	public boolean hasClubMember(String clubId, String email) {
		// 
		ClubMember clubMember = clubMemberMapper.selectClubMember(clubId, email);
		return clubMember != null ? true : false;
	}
	
	private boolean isExistClubByName(String clubName) {
		Club club = clubMapper.selectClubByName(clubName);
		return club != null ? true : false;
	}
	
	private boolean hasMember(String clubId, String email) {
		//
		ClubMember clubMember = clubMemberMapper.selectClubMember(clubId, email);
		return clubMember != null ? true : false;
	}

}
