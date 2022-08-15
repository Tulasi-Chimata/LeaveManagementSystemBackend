package com.leavesystem.controller;

import java.util.List;

import javax.validation.Valid;
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

import com.leavesystem.dto.AuthorityDto;
import com.leavesystem.dto.UserDto;
import com.leavesystem.service.AuthorityService;
import com.leavesystem.service.CustomUserService;


@RequestMapping("/addnew")
@RestController
@CrossOrigin
public class AddUserController {
	
	@Autowired
	public CustomUserService customservice;
	
	@Autowired
	public AuthorityService service;
	
	
	@PostMapping("/save")
	public UserDto saveUser(@Valid @RequestBody UserDto user){
		return customservice.addUser(user);
	}
	
	@GetMapping("/{id}")
	public UserDto getting(@PathVariable int id) {
		return customservice.getById(id);
	}
	
	@GetMapping("/getAllUsers")
	public List<UserDto> getAll(){
		return customservice.getUsers();
	}
	
	@GetMapping("/findby/{username}")
	public UserDto getUserByName(@PathVariable String username){
		return customservice.getByUsername(username);
	}
	
	@PutMapping("/updateuser/{id}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto user,@PathVariable int id){
		UserDto users = customservice.getById(id);
		users.setUsername(user.getUsername());
		users.setPhonenumber(user.getPhonenumber());
		users.setDesignation(user.getDesignation());
		users.setSupervisor(user.getSupervisor());
		users.setEmail(user.getEmail());
		UserDto update = customservice.updateAdder(users);
		return ResponseEntity.ok(update);
	}
	
	@PutMapping("/updateByAdmin/{id}")
	public ResponseEntity<UserDto> updateByAdmin(@RequestBody UserDto user,@PathVariable int id){
		UserDto users = customservice.getById(id);
		users.setAllotedleave(user.getAllotedleave());
		UserDto update = customservice.updateAdder(users);
		return ResponseEntity.ok(update);
	}
	
	@PutMapping("/updatePassword/{id}")
	public ResponseEntity<UserDto> updatePassword(@RequestBody UserDto user,@PathVariable int id){
		UserDto users = customservice.getById(id);
		users.setPassword(user.getPassword());
		UserDto update = customservice.updateAdder(users);
		return ResponseEntity.ok(update);
	}
	
	@PutMapping("/updateAuthority/{id}")
	public ResponseEntity<AuthorityDto> updateAuths(@RequestBody AuthorityDto user,@PathVariable int id){
		AuthorityDto auth = service.getById(id);
		auth.setRoleCode(user.getRoleCode());
		auth.setRoleDescription(user.getRoleDescription());
		AuthorityDto auths = service.update(auth);
		return ResponseEntity.ok(auths);
	}
	
	
	@GetMapping("/getAuthority/{id}")
	public AuthorityDto getResponse(@PathVariable int id) {
		return service.getById(id);
	}
	
	@GetMapping("/getBySupervisor/{supervisor}")
	public List<UserDto> userSupervisor(@PathVariable String supervisor){
		return customservice.getBySupervisor(supervisor);
	}
	@DeleteMapping("/deleteuser/{id}")
	public void deleter(@PathVariable int id) {
		customservice.deleteById(id);
	}
}
