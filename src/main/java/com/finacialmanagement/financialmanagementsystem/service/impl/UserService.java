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

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User userRegister(UserDto userDto) {
        User newUser = new User();
        newUser.setId(userDto.getId());
        newUser.setUsername(userDto.getUsername());
        newUser.setEmail(userDto.getEmail());
        newUser.setPassword(this.passwordEncoder.encode(userDto.getPassword()));

        return userRepository.save(newUser);
    }

    @Override
    public Object userLogin(LoginDto loginDto) {
        User user = userRepository.findByEmail(loginDto.getEmail());
        if (user != null) {
            String password = loginDto.getPassword();
            String encodedPassword = user.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> userOptional = userRepository.findOneByEmailAndPassword(loginDto.getEmail(), encodedPassword);
                if (userOptional.isPresent()) {
                    return user;
                } else {
                    return new LoginMessage("Login Failed", false);
                }
            } else {
                return new LoginMessage("Password Not Match", false);
            }
        } else {
            return new LoginMessage("Email not exists", false);
        }
    }
}
