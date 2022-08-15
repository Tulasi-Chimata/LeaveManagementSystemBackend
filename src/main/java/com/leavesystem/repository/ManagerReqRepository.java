package com.leavesystem.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leavesystem.dto.ManagerReqDto;
import com.leavesystem.model.ManagerReq;

@Repository
public interface ManagerReqRepository extends JpaRepository<ManagerReq,Integer> {

	ManagerReq save(ManagerReqDto user);


	ManagerReq findByLeaveid(String leaveid);




	List<ManagerReq> getByManagerid(String managerid);

	


	
	
	
	

}
