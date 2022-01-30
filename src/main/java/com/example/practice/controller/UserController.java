package com.example.practice.controller;


import com.example.practice.business.UserBusiness;
import com.example.practice.entity.User;
import com.example.practice.entity.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserBusiness userBusiness;

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody User user) {
        userBusiness.saveUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLogin user){
        userBusiness.findUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/save/user")
    public ResponseEntity<Void> User(@Valid @RequestBody User user) {
        userBusiness.saveUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/user/{request}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Long request) {
        Optional<User> response = userBusiness.getUserByID(request);
        return new ResponseEntity<Optional<User>>(response, HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<Iterable<User>> getAllUser() {
        Iterable<User> response = userBusiness.getUsers();
        return new ResponseEntity<Iterable<User>>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/users")
    public ResponseEntity<Void> deleteAllUser() {
        userBusiness.deleteUsers();
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userBusiness.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


}
