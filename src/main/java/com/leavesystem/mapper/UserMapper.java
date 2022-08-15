package com.leavesystem.mapper;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.leavesystem.dto.UserDto;
import com.leavesystem.model.User;







@Component
public class UserMapper {
	
	
	public UserDto toUserDto(User user) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(user, UserDto.class);
	}
	
	public User toUser(UserDto user) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(user,User.class);
	}
	
	public List<UserDto> toUserDtos(List<User> user){
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return Arrays.asList(mapper.map(user, UserDto[].class));
	}
}
