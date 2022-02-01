package com.example.practice.service;

import com.example.practice.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {

    // repository
    private final ProductRepository productRespository;

    public StudentService(ProductRepository productRespository) {
        this.productRespository = productRespository;
    }


    @GetMapping
    public List<Student> getStudent() {
        return List.of(new Student(
                1L,
                "Attaporn",
                "aofattapon321@gmail.com",
                LocalDate.of(2002, Month.FEBRUARY, 2),
                21
        ));
    }


}
