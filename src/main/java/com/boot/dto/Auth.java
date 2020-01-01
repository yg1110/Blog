package com.boot.dto;

public class Auth {
	private long usuario_id;
	private long authority_id;
	
	public Auth() {
		super();
	}

	public long getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(long usuario_id) {
		this.usuario_id = usuario_id;
	}

	public long getAuthority_id() {
		return authority_id;
	}

	public void setAuthority_id(long authority_id) {
		this.authority_id = authority_id;
	}

	
}
