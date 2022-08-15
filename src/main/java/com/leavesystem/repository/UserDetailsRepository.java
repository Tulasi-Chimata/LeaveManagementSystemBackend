package com.leavesystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leavesystem.dto.UserDto;
import com.leavesystem.model.User;




@Repository
public interface UserDetailsRepository extends JpaRepository<User,Integer>{
	 User findByUsername(String username);

	 Object getById(long id);

	User save(UserDto user);

	List<User> findBySupervisor(String supervisor);

}
