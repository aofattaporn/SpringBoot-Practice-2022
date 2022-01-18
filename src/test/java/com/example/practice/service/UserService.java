package com.example.practice.service;

import com.example.practice.TestData;
import com.example.practice.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void TestSaveUser(){

//        TestData   = new TestData();
//        userRepository.save();

//        Assertions.assertTrue();
    }


}
