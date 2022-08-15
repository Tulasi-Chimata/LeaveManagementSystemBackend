package com.leavesystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leavesystem.dto.ManagerReqDto;
import com.leavesystem.model.ManagerReq;
import com.leavesystem.service.ManagerReqService;

@RestController
@CrossOrigin
@RequestMapping("/managereq")
public class ManagerReqController {

	@Autowired
	public ManagerReqService service;
	
	@PutMapping("/update/{id}")
	public ResponseEntity<ManagerReq> updateRequest(@RequestBody ManagerReq user,@PathVariable int id){
		ManagerReq req = service.getById(id);
		req.setLeaveid(user.getLeaveid());
		req.setManageremail(user.getManageremail());
		req.setManagerid(user.getManagerid());
		req.setManagername(user.getManagername());
		req.setReason(user.getReason());
		req.setResponse(user.getResponse());
		ManagerReq mans = service.updater(req);
		return ResponseEntity.ok(mans);
	}
	
	@GetMapping("/getleave/{leaveid}")
	public ManagerReq findLeaveid(@PathVariable String leaveid) {
		return service.getByLeaveid(leaveid);
	}
	
	
	@GetMapping("/getAllRequests")
	public List<ManagerReqDto> getting() {
		return service.getAllRequests();
	}
	
	
	@GetMapping("/getManagerReq/{id}")
	public ManagerReq getResponse(@PathVariable int id) {
		return service.getById(id);
	}
	
	@PostMapping("/addManagerReq")
	public ManagerReqDto addManagerReq(@RequestBody ManagerReqDto user1) {
		return service.addManagerReq(user1);
	}
	@GetMapping("/getbyManager/{managerid}")
	public List<ManagerReq> getManagerid(@PathVariable String managerid) {
		return service.getByManagerid(managerid);
	}
	

}
