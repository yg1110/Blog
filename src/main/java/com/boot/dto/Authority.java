package com.boot.dto;

import org.springframework.data.annotation.Id;

public class Authority {

	@Id
	private Long id;
	
	private String authority;
	
	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
}