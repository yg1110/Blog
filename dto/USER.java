package com.boot.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

<<<<<<< HEAD:src/main/java/com/boot/dto/User.java
@RedisHash("User")
=======
@RedisHash("USER")
>>>>>>> 87f20bb2bbaac7d45c065a9988f74bc395f72ebd:dto/USER.java
public class USER {
	@Id
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
	
	public USER(String email, String pwd, int auth) {
		super();
		this.email = email;
		this.pwd = pwd;
		this.auth = auth;
	}
	
	public USER(String email, String pwd) {
		super();
		this.email = email;
		this.pwd = pwd;
	}
	
	public USER() {
		super();
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", pwd=" + pwd + ", auth=" + auth + "]";
	}
}
