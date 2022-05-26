package com.example.practice.controller;

import com.example.practice.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/vi/students")
public class StudentConteroller {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "Jame Bond"),
            new Student(2, "Maria Jones"),
            new Student(3, "Anna Smith")
    );

    @GetMapping
    public List<Student> getStudents(){
        return STUDENTS;
    }

    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable Integer studentId){
        return STUDENTS.get(studentId);
    }


}
