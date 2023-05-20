package com.mybloggingapp.services;

import com.mybloggingapp.entities.User;
import com.mybloggingapp.payloads.UserDto;

import java.util.List;

public interface UserService {

   UserDto createUser(UserDto user);
   UserDto updateUser(UserDto user, Integer userId);
   UserDto getUserById(Integer userId);
   List<UserDto> getAllUsers();

   void deleteUser(Integer userId);

   UserDto updateUser(UserDto userDto);
}
