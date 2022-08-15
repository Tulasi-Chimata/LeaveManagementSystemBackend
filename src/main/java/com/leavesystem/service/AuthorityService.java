package com.leavesystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leavesystem.dto.AuthorityDto;
import com.leavesystem.mapper.AuthorityMapper;
import com.leavesystem.model.Authority;
import com.leavesystem.repository.AuthRepository;


@Service
public class AuthorityService {
	
	@Autowired
	private AuthorityMapper mapper;
	@Autowired
	private AuthRepository repository;
	
	
	public AuthorityDto getById(int id) {
		Optional<Authority>auth = repository.findById(id);
		Authority auths = null;
		if(auth.isPresent()) {
			auths = auth.get();
		}
		return mapper.toAuthorityDto(auths);
	}
	
	public AuthorityDto update(AuthorityDto auth) {
		if(getById(auth.getId())==null) {
			return null;
		}
		Authority auths = repository.save(auth);
		return mapper.toAuthorityDto(auths);
	}
}
