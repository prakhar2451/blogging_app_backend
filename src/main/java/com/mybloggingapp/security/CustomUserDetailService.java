package com.mybloggingapp.security;

import com.mybloggingapp.exceptions.ResourceNotFoundException;
import com.mybloggingapp.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //loading user from database by username
        return (UserDetails) this.userRepo.findByEmail(username).orElseThrow(()->new ResourceNotFoundException("USer", "user email : "+username,0));
    }
}
