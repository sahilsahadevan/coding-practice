package com.example.sahil.practice;

import com.example.sahil.practice.string_manipulation.PrintEquilateralPyramids;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CodingPracticeApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CodingPracticeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        PrintEquilateralPyramids.printEquilateralNumberPyramidIncrementalOne();
    }
}
