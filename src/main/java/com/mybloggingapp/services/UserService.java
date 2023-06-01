package com.mybloggingapp.services;

import com.mybloggingapp.entities.User;
import com.mybloggingapp.payloads.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

   UserDto createUser(UserDto user);
   UserDto updateUser(UserDto user, Integer userId);
   UserDto getUserById(Integer userId);
   List<UserDto> getAllUsers();

   void deleteUser(Integer userId);

   UserDto updateUser(UserDto userDto);
}
