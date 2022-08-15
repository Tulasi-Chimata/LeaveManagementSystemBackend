package com.leavesystem.dto;



import org.springframework.security.core.GrantedAuthority;




public class AuthorityDto implements GrantedAuthority{
	
	
	private int id;
	
	private String roleCode;
	
	private String roleDescription;
	
	//Getters And Setters
	
	@Override
	public String getAuthority() {
		return null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public AuthorityDto() {
		super();
	}
	
	

}
