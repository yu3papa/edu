/*
 * COPYRIGHT (c) Nextree Consulting 2014
 * This software is the proprietary of Nextree Consulting.  
 * 
 * @author <a href="mailto:tsong@nextree.co.kr">Song, Taegook</a>
 * @since 2014. 5. 10.
 */

package com.namoo.club.regist.domain.service.dto;

import com.namoo.club.regist.domain.entity.Towner;
import com.namoo.club.util.JsonUtil;

public class TownerCDto {
	//
	private String name; 
	private String email; 
	private String password; 
	
	//--------------------------------------------------------------------------
	public TownerCDto() {
	}
	
	public TownerCDto(String name, String email, String password) {
		// 
		this.name = name; 
		this.email = email; 
		this.password = password;
	}
	
	//--------------------------------------------------------------------------
	public Towner createDomain() {
		// 
		return new Towner(name, email, password); 
	}

	public String toJson() {
		//
		return JsonUtil.toJson(this); 
	}

	public static TownerCDto fromJson(String jsonString) {
		// 
		return (TownerCDto) JsonUtil.fromJson(jsonString, TownerCDto.class); 
	}
	
	public String getName() {
		return name; 
	}
	
	public String getEmail() {
		return email; 
	}
	
	public String getPassword() {
		return password; 
	}
}