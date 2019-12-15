package com.boot.dto;

public class User {
	private String email;
	private String pwd;
	private int auth;
	
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
	
	public int getAuth() {
		return auth;
	}
	
	public void setAuth(int auth) {
		this.auth = auth;
	}
	
	public User(String email, String pwd, int auth) {
		super();
		this.email = email;
		this.pwd = pwd;
		this.auth = auth;
	}
	
	public User(String email, String pwd) {
		super();
		this.email = email;
		this.pwd = pwd;
	}
	
	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", pwd=" + pwd + ", auth=" + auth + "]";
	}
}
