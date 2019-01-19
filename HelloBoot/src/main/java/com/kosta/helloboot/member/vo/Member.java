package com.kosta.helloboot.member.vo;

import org.hibernate.validator.constraints.NotEmpty;

public class Member {
	private long index;
	public long getIndex() {
		return index;
	}
	public void setIndex(long index) {
		this.index = index;
	}
	
	@NotEmpty(message="name field is mandatory filed")
	private String name;
	
	@NotEmpty(message="email field is mandatory filed")
	private String email;
	
	@NotEmpty(message="password field is mandatory filed")
	private String password;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
