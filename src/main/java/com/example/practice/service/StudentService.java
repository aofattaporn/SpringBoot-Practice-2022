package com.example.practice.service;

import com.example.practice.entity.Product;
import com.example.practice.entity.Student;
import com.example.practice.respoditory.ProductRespository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {

    // repository
    private final ProductRespository productRespository;

    public StudentService(ProductRespository productRespository) {
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
