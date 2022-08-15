package com.leavesystem.mapper;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.leavesystem.dto.LeaveTypeDto;
import com.leavesystem.model.LeaveType;




@Component
public class LeaveTypeMapper {

	
	public LeaveTypeDto toLeaveDto(LeaveType leave) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(leave, LeaveTypeDto.class);
	}
	
	public LeaveType toLeave(LeaveTypeDto leave) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(leave,LeaveType.class);
	}
	
	public List<LeaveTypeDto> toLeaveDtos(List<LeaveType> leave){
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return Arrays.asList(mapper.map(leave, LeaveTypeDto[].class));
	}
	
	
}
