package com.jadecross.perflab.domain;

public class Towner {
	private String towner_name;
	public String getTowner_name() {
		return towner_name;
	}

	public void setTowner_name(String towner_name) {
		this.towner_name = towner_name;
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

	private String email;
	private String password;
	
	public Towner() {
		//
	}

}
