package com.example.practice.service;

import com.example.practice.entity.User;
import com.example.practice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @GetMapping
    public Optional<User> getUserById(Long id) {
        Optional<User> userId = userRepository.findById(id);
        return userId;
    }

    @GetMapping
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @DeleteMapping
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @DeleteMapping
    public void deleteUsers() {
        userRepository.deleteAll();
    }
}
