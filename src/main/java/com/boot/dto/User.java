package com.boot.dto;

public class User {
	private String email;
	private String pwd;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public User(String email, String pwd) {
		super();
		this.email = email;
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "User [email=" + email + ", pwd=" + pwd + "]";
	}
	public User() {
		super();
	}
	
}
