package com.np.userinfo.service;

import java.util.List;

import com.np.userinfo.dto.UserDto;

public interface UserService {

	List<UserDto> fetchAllUsers();

	UserDto getUserById(Integer user_id);

	UserDto addUser(UserDto user);

}
