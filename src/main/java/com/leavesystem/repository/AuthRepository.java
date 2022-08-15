package com.leavesystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leavesystem.dto.AuthorityDto;
import com.leavesystem.model.Authority;



public interface AuthRepository extends JpaRepository<Authority,Integer>{

	Authority save(AuthorityDto auth);

	

}
