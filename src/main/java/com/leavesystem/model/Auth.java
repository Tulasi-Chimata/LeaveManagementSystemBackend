package com.leavesystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name="AUTH_USER_AUTHORITY")

public class Auth {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userid;
	
	@Column(name="authorities_id")
	private int authoritiesid;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getAuthoritiesid() {
		return authoritiesid;
	}

	public void setAuthoritiesid(int authoritiesid) {
		this.authoritiesid = authoritiesid;
	}

	public Auth() {
		super();

	}
	
	//Getters and Setters
	
	
	
}
	
	
	
	
