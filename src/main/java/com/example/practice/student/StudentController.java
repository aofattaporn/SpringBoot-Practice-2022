package com.example.practice.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/student")
public class StudentController {

    @GetMapping
    public List<Student> echoJello() {
        return List.of(new Student(
                1L,
                "Attaporn",
                "aofattapon321@gmail.com",
                LocalDate.of(2002, Month.FEBRUARY, 2),
                21

        ));
    }

}
