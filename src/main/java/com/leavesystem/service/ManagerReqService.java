package com.leavesystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leavesystem.dto.ManagerReqDto;

import com.leavesystem.mapper.ManagerReqMapper;
import com.leavesystem.model.ManagerReq;

import com.leavesystem.repository.ManagerReqRepository;

@Service
public class ManagerReqService {
	@Autowired
	private ManagerReqRepository repository;
	
	@Autowired
	private ManagerReqMapper mapper;
	
	
	public ManagerReqDto addManagerReq(ManagerReqDto user) {
		ManagerReq user1 = mapper.toManagerReq(user);
		user1 = repository.save(user1);
		return mapper.toManagerReqDto(user1);
	}
	public ManagerReq getById(int id) {
		Optional<ManagerReq>man = repository.findById(id);
		ManagerReq mans = null;
		if(man.isPresent()) {
			mans = man.get();
		}
		return mans;
	}
	public List<ManagerReqDto>getAllRequests(){
		List<ManagerReq>list = repository.findAll();
		return mapper.toManagerReqDtos(list);
	}
	
	public ManagerReq getByLeaveid(String leaveid) {
		return repository.findByLeaveid(leaveid);
	}
	
	public ManagerReq updater(ManagerReq value) {
		if(getById(value.getId())==null) {
			return null;
		}
		return repository.save(value);
	}
	public List<ManagerReq> getByManagerid(String managerid) {
		return repository.getByManagerid(managerid);
	}
	
	
}
