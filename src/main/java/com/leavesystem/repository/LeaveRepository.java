package com.leavesystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leavesystem.dto.LeaveTypeDto;
import com.leavesystem.model.LeaveType;



@Repository
public interface LeaveRepository extends JpaRepository<LeaveType,Integer>{

	List<LeaveType> findByUserid(long userid);

	LeaveType save(LeaveTypeDto leave);

	List<LeaveType> findBySupervisor(String supervisor);

}
