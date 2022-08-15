package com.leavesystem.mapper;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.leavesystem.dto.AuthorityDto;
import com.leavesystem.model.Authority;







@Component
public class AuthorityMapper {
	
	
	public AuthorityDto toAuthorityDto(Authority auth) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(auth, AuthorityDto.class);
	}
	
	public Authority toAuthority(AuthorityDto auth) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(auth,Authority.class);
	}
	
	public List<AuthorityDto> toAuthorityDtos(List<Authority> auth){
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return Arrays.asList(mapper.map(auth, AuthorityDto[].class));
	}
}
