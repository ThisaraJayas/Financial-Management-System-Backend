package com.finacialmanagement.financialmanagementsystem.service;

import com.finacialmanagement.financialmanagementsystem.entity.User;
import com.finacialmanagement.financialmanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User userRegister(User user){
        User newUser = new User(
                user.getUserId(),
                user.getName(),
                user.getEmail(),
                this.passwordEncoder.encode( user.getPassword())
        );
        return userRepository.save(newUser);

    }
}
