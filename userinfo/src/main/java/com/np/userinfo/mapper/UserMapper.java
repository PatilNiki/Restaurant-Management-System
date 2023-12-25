package com.np.userinfo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.np.userinfo.dto.UserDto;
import com.np.userinfo.entity.User;

@Mapper
public interface UserMapper {
	
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	UserDto mapUserToUserDto(User user);
	
	User mapUserDtoToUser(UserDto userDto);

}
