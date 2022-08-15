package com.leavesystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leavesystem.dto.LeaveTypeDto;
import com.leavesystem.mapper.LeaveTypeMapper;
import com.leavesystem.model.LeaveType;
import com.leavesystem.repository.LeaveRepository;

@Service
public class LeaveTypeService {
	
	@Autowired
	private LeaveRepository repository;
	
	@Autowired
	private LeaveTypeMapper mapper;
	
	public LeaveTypeDto addLeave(LeaveTypeDto leave) {
		LeaveType type = mapper.toLeave(leave);
		type = repository.save(type);
		return mapper.toLeaveDto(type);
	}
	
	public List<LeaveTypeDto>getAllRequests(){
		List<LeaveType>list = repository.findAll();
		return mapper.toLeaveDtos(list);
	}
	
	public List<LeaveTypeDto> getByUserid(long userid){
		List<LeaveType> leave = repository.findByUserid(userid);
		return mapper.toLeaveDtos(leave);
	}
	
	public List<LeaveTypeDto> getBySupervisor(String supervisor){
		List<LeaveType>leave = repository.findBySupervisor(supervisor);
		return mapper.toLeaveDtos(leave);
	}
	
	public LeaveTypeDto getById(int leaverequestid){
		Optional<LeaveType> leave = repository.findById(leaverequestid);
		LeaveType types = null;
		if(leave.isPresent()) {
			types = leave.get();
		}
		return mapper.toLeaveDto(types);
	}
	
	public void deleteById(int id) {
		repository.deleteById(id);
	}
	
	
	public LeaveTypeDto updateDetails(LeaveTypeDto leave) {
		if(getById(leave.getLeaverequestid())==null) {
			return null;
		}
		LeaveType list = repository.save(leave);
		return mapper.toLeaveDto(list);
	}
	
	
}
