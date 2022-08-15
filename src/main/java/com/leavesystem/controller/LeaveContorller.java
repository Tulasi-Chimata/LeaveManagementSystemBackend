package com.leavesystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leavesystem.dto.LeaveTypeDto;
import com.leavesystem.service.LeaveTypeService;

@RestController
@CrossOrigin
@RequestMapping("/leave")
public class LeaveContorller {
	
	
	@Autowired
	private LeaveTypeService service;
	
 
	
	@PostMapping("/addLeave")
	public LeaveTypeDto adder(@RequestBody LeaveTypeDto type) {
		return service.addLeave(type);
	}
	
	@GetMapping("/{leaverequestid}")
	public LeaveTypeDto getter(@PathVariable int leaverequestid) {
		return service.getById(leaverequestid);
	}
	
	@GetMapping("/getAllLeaves")
	public List<LeaveTypeDto> getting() {
		return service.getAllRequests();
	}
	
	@GetMapping("/getBySuperVisor/{supervisor}")
	public List<LeaveTypeDto> gettBySuper(@PathVariable String supervisor){
		return service.getBySupervisor(supervisor);
	}
	
	@GetMapping("/getByUserid/{userid}")
	public List<LeaveTypeDto> getsById(@PathVariable long userid){
		return service.getByUserid(userid);
	}
	
	@DeleteMapping("/deleteleaverequest/{leaverequestid}")
	public void deleter(@PathVariable int leaverequestid) {
		service.deleteById(leaverequestid);
	}
	
	@PutMapping("/updateleave/{leaverequestid}")
	public ResponseEntity<LeaveTypeDto> updater(@PathVariable int leaverequestid,@RequestBody LeaveTypeDto type) {
		LeaveTypeDto types = service.getById(leaverequestid);
		types.setStartDate(type.getStartDate());
		types.setEndDate(type.getStartDate());
		types.setDays(type.getDays());
		types.setAllotedLeave(type.getAllotedLeave());
		types.setStatus(type.getStatus());
		types.setType(type.getType());
		types.setReason1(type.getReason1());
		types.setReason2(type.getReason2());
		types.setDesignation(type.getDesignation());
		LeaveTypeDto update = service.addLeave(types);
		return ResponseEntity.ok(update);
	}
	

}
