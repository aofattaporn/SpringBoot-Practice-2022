package com.example.practice.controller;


import com.example.practice.entity.User;
import com.example.practice.exception.UserException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController  {

    @PostMapping("/users")
    ResponseEntity<String> addUser(@Valid @RequestBody User user) throws UserException {
        return ResponseEntity.ok("User is valid");
    }

}
