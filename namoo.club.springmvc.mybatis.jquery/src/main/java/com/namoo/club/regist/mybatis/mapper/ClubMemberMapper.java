/*
 * COPYRIGHT (c) Nextree Consulting 2014
 * This software is the proprietary of Nextree Consulting.  
 * 
 * @author <a href="mailto:hkkang@nextree.co.kr">Kang, HyoungKoo</a>
 * @since 2014. 6. 14.
 */

package com.namoo.club.regist.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.namoo.club.regist.domain.entity.Club;
import com.namoo.club.regist.domain.entity.ClubMember;

public interface ClubMemberMapper {
	//
	public void insertClubMember(@Param("clubId") String clubId, @Param("member") ClubMember member);
	
	public ClubMember selectClubMember(@Param("clubId") String clubId, @Param("memberEmail") String memberEmail);
	public List<ClubMember> selectAllClubMember(String clubId);
	public List<Club> selectJoinedClub(String memberEmail);
	public List<Club> selectUnjoinedClub(String memberEmail);
	
	public void deleteClubMember(@Param("clubId") String clubId, @Param("memberEmail") String memberEmail);
	
	public int countMembers(String clubId);
}
