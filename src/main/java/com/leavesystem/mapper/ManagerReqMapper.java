package com.leavesystem.mapper;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.leavesystem.dto.ManagerReqDto;
import com.leavesystem.model.ManagerReq;

@Component
public class ManagerReqMapper {
	public ManagerReqDto toManagerReqDto(ManagerReq man) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(man, ManagerReqDto.class);
	}
	
	public ManagerReq toManagerReq(ManagerReqDto man) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(man,ManagerReq.class);
	}
	
	public List<ManagerReqDto> toManagerReqDtos(List<ManagerReq> man){
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return Arrays.asList(mapper.map(man, ManagerReqDto[].class));
	}
}
