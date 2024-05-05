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
@RequestMapping("users")
@CrossOrigin("http://localhost:5173")
public class UserController {

    @Autowired
    UserServiceI userService;

    @GetMapping("/welcome")
    public String This(){
        return "THis Page";
    }

    @PostMapping("/register")
    public User Register(@RequestBody UserDto user){
        return userService.userRegister(user);
    }
    @PostMapping("/login")
    public ResponseEntity<?>Login(@RequestBody LoginDto login){
        Object loginMessage = userService.userLogin(login);
        return ResponseEntity.ok(loginMessage);
    }
//    @PostMapping  ("/login")
//    public ResponseEntity<UserDetails> login(@RequestBody User user){
//        String username = user.getEmail();
//        String password = user.getPassword();
//        Authentication authentication= authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(username, password)
//        );
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        return new ResponseEntity<UserDetails>((UserDetails) user, HttpStatus.OK);
//    }



//    @PostMapping("/login")
//    public User Login(@RequestBody User user){
//       return (User) userService.loadUserByUsername(user.getName());
//    }

}
