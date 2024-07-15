package com.finacialmanagement.financialmanagementsystem.controller;

import com.finacialmanagement.financialmanagementsystem.dto.LoginDto;
import com.finacialmanagement.financialmanagementsystem.dto.UserDto;
import com.finacialmanagement.financialmanagementsystem.entity.User;
import com.finacialmanagement.financialmanagementsystem.response.LoginMessage;
import com.finacialmanagement.financialmanagementsystem.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth/users")
@CrossOrigin("http://localhost:5173")
public class UserController {

    @Autowired
    UserServiceI userService;

    @GetMapping("/test")
    public String test() {
        return "This Page";
    }

    @PostMapping("/register")
    public User register(@RequestBody UserDto user) {
        return userService.userRegister(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto login) {
        Object loginMessage = userService.userLogin(login);
        return ResponseEntity.ok(loginMessage);
    }
}