package com.example.practice.controller;


import com.example.practice.entity.User;
import com.example.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("save/user")
    public ResponseEntity<Void> addUser(@Valid @RequestBody User user) {
        userService.saveUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id) {
        Optional<User> response = userService.getUserById(id);
        return new ResponseEntity<Optional<User>>(response, HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<Iterable<User>> getAllUser() {
        Iterable<User> response = userService.getUsers();
        return new ResponseEntity<Iterable<User>>(response, HttpStatus.OK);
    }

    @DeleteMapping("delete/users")
    public ResponseEntity<Void> deleteUser() {
        userService.deleteUsers();
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("delete/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


}
