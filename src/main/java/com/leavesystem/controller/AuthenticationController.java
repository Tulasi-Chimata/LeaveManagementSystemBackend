package com.leavesystem.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leavesystem.config.JwtTokenHelper;
import com.leavesystem.dto.AuthorityDto;
import com.leavesystem.model.User;
import com.leavesystem.respose.AuthenticationRequest;
import com.leavesystem.respose.LoginResponse;
import com.leavesystem.respose.UserInfo;
import com.leavesystem.service.AuthorityService;




@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	JwtTokenHelper jWTTokenHelper;
	
	@Autowired
	private AuthorityService service;
	
	@Autowired
	private UserDetailsService userDetailsService;

	@PostMapping("/auth/login")
	public ResponseEntity<LoginResponse> login(@RequestBody AuthenticationRequest authenticationRequest)  {

		final Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		User user=(User)authentication.getPrincipal();
		String jwtToken=jWTTokenHelper.generateToken(user.getUsername());
		
		LoginResponse response=new LoginResponse();
		response.setToken(jwtToken);
		return ResponseEntity.ok(response);
	}
	
	
	
	@GetMapping("/auth/userinfo")
	public ResponseEntity<UserInfo> getUserInfo(Principal user){
		User userObj=(User) userDetailsService.loadUserByUsername(user.getName());

		AuthorityDto auth = service.getById(userObj.getId());
		UserInfo userInfo=new UserInfo();
		userInfo.setId(userObj.getId());
		userInfo.setUsername(userObj.getUsername());
		userInfo.setTotalleaves(userObj.getAllotedleave());
		userInfo.setPassword(userObj.getPassword());
		userInfo.setEmail(userObj.getEmail());
		userInfo.setPhonenumber(userObj.getPhonenumber());
		userInfo.setDesignation(userObj.getDesignation());
		userInfo.setSupervisor(userObj.getSupervisor());
		userInfo.setRoles(userObj.getAuthorities().toArray());
		userInfo.setRoleCode(auth.getRoleCode());
		return ResponseEntity.ok(userInfo);	
		
	}
	
	
}