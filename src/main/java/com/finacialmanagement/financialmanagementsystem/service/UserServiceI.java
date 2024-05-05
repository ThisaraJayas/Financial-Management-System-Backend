package com.finacialmanagement.financialmanagementsystem.service;

import com.finacialmanagement.financialmanagementsystem.dto.LoginDto;
import com.finacialmanagement.financialmanagementsystem.dto.UserDto;
import com.finacialmanagement.financialmanagementsystem.entity.User;
import com.finacialmanagement.financialmanagementsystem.response.LoginMessage;


public interface UserServiceI{

    User userRegister(UserDto user);

    Object userLogin(LoginDto login);


//    @Override
//    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
//        User user = userRepository.findByUsernameOrEmail(usernameOrEmail,usernameOrEmail)
//                .orElseThrow(()-> new UsernameNotFoundException("Username or email not found"));
//        return (UserDetails) user;
//    }


//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found with username: " + username);
//        }
//        return org.springframework.security.core.userdetails.User.builder()
//                .username(user.getEmail())
//                .password(user.getPassword())
//                .roles("USER") // You can set roles here if needed
//                .build();
//    }
}
