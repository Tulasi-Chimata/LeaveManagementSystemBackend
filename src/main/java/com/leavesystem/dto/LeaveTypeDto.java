package com.leavesystem.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

public class LeaveTypeDto {
	
	private int leaverequestid;
	
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	private Date endDate;
	
	private int days;
	private String type;
	
	private String status;
	
	private String reason1;
	private String reason2;
	@Column(name="userid")
	private Long userid;
	
	private int allotedLeave;
	
	private String designation;
	private String supervisor;
	
	private String username;
	
	
	
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
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
	
	

	
	public int getAllotedLeave() {
		return allotedLeave;
	}

	public void setAllotedLeave(int allotedLeave) {
		this.allotedLeave = allotedLeave;
	}
	
	public LeaveTypeDto(){
		super();
	}


	

	public String getReason1() {
		return reason1;
	}




	




	public void setReason1(String reason1) {
		this.reason1 = reason1;
	}




	public String getReason2() {
		return reason2;
	}




	public void setReason2(String reason2) {
		this.reason2 = reason2;
	}




	public int getLeaverequestid() {
		return leaverequestid;
	}




	public void setLeaverequestid(int id) {
		this.leaverequestid = id;
	}




	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public int getDays() {
		return days;
	}


	public void setDays(int days) {
		this.days = days;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Long getUserid() {
		return userid;
	}


	public void setUserid(Long userid) {
		this.userid = userid;
	}

	
	
	

}
