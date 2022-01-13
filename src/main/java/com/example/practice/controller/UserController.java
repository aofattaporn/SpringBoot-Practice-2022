package com.example.practice.controller;


import com.example.practice.entity.User;
import com.example.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController  {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    ResponseEntity<String> addUser(@Valid @RequestBody User user){
        return ResponseEntity.ok("User is valid");
    }

//    @GetMapping("user/{id}")
//    public ResponseEntity<User> getUser(@PathVariable double id){
//        return  ResponseEntity.ok(new User(0 , "s", "a"));
//    }

}
