/*
 * COPYRIGHT (c) Nextree Consulting 2014
 * This software is the proprietary of Nextree Consulting.  
 * 
 * @author <a href="mailto:tsong@nextree.co.kr">Song, Taegook</a>
 * @since 2014. 5. 10.
 */

package com.namoo.club.regist.domain.service.dto;

import com.namoo.club.regist.domain.entity.Club;
import com.namoo.club.regist.domain.entity.ClubAdmin;
import com.namoo.club.util.JsonUtil;

public class ClubCDto {
	//
	private String clubName; 
	private String description; 
	private String adminEmail; 
	
	//--------------------------------------------------------------------------
	public ClubCDto() {
	}
	
	public ClubCDto(String clubName, String description, String adminEmail) {
		// 
		this.clubName = clubName; 
		this.description = description; 
		this.adminEmail = adminEmail; 
	}

	//--------------------------------------------------------------------------
	public Club createDomain(ClubAdmin admin) {
		// 
		return new Club(clubName, description, admin); 
	}

	public String toJson() {
		//
		return JsonUtil.toJson(this); 
	}

	public static ClubCDto fromJson(String jsonString) {
		// 
		return (ClubCDto) JsonUtil.fromJson(jsonString, ClubCDto.class); 
	}
	
	public String getClubName() {
		return clubName;
	}

	public String getDescription() {
		return description;
	}

	public String getAdminEmail() {
		return adminEmail;
	}
}