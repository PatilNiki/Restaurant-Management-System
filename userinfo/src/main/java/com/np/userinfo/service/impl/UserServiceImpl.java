package com.np.userinfo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.np.userinfo.dto.UserDto;
import com.np.userinfo.mapper.UserMapper;
import com.np.userinfo.repo.UserRepository;
import com.np.userinfo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<UserDto> fetchAllUsers() {
		return userRepository.findAll().stream().map(user -> UserMapper.INSTANCE.mapUserToUserDto(user)).collect(Collectors.toList());
	}

	@Override
	public UserDto getUserById(Integer user_id) {
		return UserMapper.INSTANCE.mapUserToUserDto(userRepository.findById(user_id).orElse(null));
	}

	@Override
	public UserDto addUser(UserDto user) {
		return UserMapper.INSTANCE.mapUserToUserDto(userRepository.save(UserMapper.INSTANCE.mapUserDtoToUser(user)));
	}

}
