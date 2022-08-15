package com.leavesystem.dto;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.leavesystem.model.Authority;
import com.leavesystem.model.LeaveType;

public class UserDto implements UserDetails{

	private int id;
	
	private String username;

	private String password;
	
	private String email;
	
	private String phonenumber;
	
	private int allotedleave;
	
	private boolean enabled=true;
	
	//Mapping To Define Authority Of The Particular User And Foreign Key For Storing Data
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "AUTH_USER_AUTHORITY", joinColumns = @JoinColumn(referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(referencedColumnName ="id"))
	private List<Authority> authorities;
	
	
	@OneToMany(targetEntity = LeaveType.class,cascade = CascadeType.ALL)
	@JoinColumn(name="userid",referencedColumnName = "id")
	private List<LeaveType> leave;
	
	private String designation;
	private String supervisor;
	
	
	
	
	
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getSupervisor() {
		return supervisor;
	}
	
	
	
	
	
	//Getters Ans Setters
	
	

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	public List<LeaveType> getLeave() {
		return leave;
	}




	public int getAllotedleave() {
		return allotedleave;
	}




	public void setAllotedleave(int allotedleave) {
		this.allotedleave = allotedleave;
	}




	public void setLeave(List<LeaveType> leave) {
		this.leave = leave;
	}




	public UserDto() {
		super();
	}

	


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.enabled;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.enabled;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.enabled;
	}

	@Override
	public boolean isEnabled() {
		return this.enabled;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
