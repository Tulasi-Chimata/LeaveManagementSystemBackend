package com.leavesystem.respose;

public class UserInfo {
	
	private long id;
	private String email;
	private String phonenumber;
	private String username;
	private String roleCode;
	private Object roles;
	private int totalleaves;
	private String designation;
	private String supervisor;
	private String password;
	

	
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	public int getTotalleaves() {
		return totalleaves;
	}

	public void setTotalleaves(int totalleaves) {
		this.totalleaves = totalleaves;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Object getRoles() {
		return roles;
	}

	public void setRoles(Object roles) {
		this.roles = roles;
	}

	
	
	
	
	
}