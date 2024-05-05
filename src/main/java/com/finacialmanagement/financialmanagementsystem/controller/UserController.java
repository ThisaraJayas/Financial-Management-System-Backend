package com.finacialmanagement.financialmanagementsystem.controller;

import com.finacialmanagement.financialmanagementsystem.entity.User;
import com.finacialmanagement.financialmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
@CrossOrigin("http://localhost:5173")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/this")
    public String This(){
        return "THis Page";
    }

    @PostMapping("/register")
    public void Register(@RequestBody User user){
        userService.userRegister(user);
    }


}
