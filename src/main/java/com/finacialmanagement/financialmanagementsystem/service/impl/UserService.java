package com.finacialmanagement.financialmanagementsystem.service.impl;

import com.finacialmanagement.financialmanagementsystem.dto.LoginDto;
import com.finacialmanagement.financialmanagementsystem.dto.UserDto;
import com.finacialmanagement.financialmanagementsystem.entity.User;
import com.finacialmanagement.financialmanagementsystem.repository.UserRepository;
import com.finacialmanagement.financialmanagementsystem.response.LoginMessage;
import com.finacialmanagement.financialmanagementsystem.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserService implements UserServiceI {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public User userRegister(UserDto user) {
        User newUser = new User(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                this.passwordEncoder.encode( user.getPassword())
        );
        return userRepository.save(newUser);
    }

    @Override
    public Object userLogin(LoginDto login) {
        String msg = "";
        User user = userRepository.findByEmail(login.getEmail());
        if (user != null) {
            String password = login.getPassword();
            String encodedPassword = user.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> user1 = userRepository.findOneByEmailAndPassword(login.getEmail(), encodedPassword);
                if (user1.isPresent()) {
                   return user;
                } else {
                    return new LoginMessage("Login Failed", false);
                }
            } else {
                return new LoginMessage("password Not Match", false);
            }
        }else {
            return new LoginMessage("Email not exits", false);
        }
    }
}
