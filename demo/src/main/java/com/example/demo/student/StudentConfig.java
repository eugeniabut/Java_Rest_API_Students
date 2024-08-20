package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewInterceptor;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
@Bean
    CommandLineRunner commandLineRunner(
        StudentRepository studentRepository, OpenEntityManagerInViewInterceptor openEntityManagerInViewInterceptor){
        return args -> {
            Student maria = new Student(

                    "Maria",
                  "maria@gmail.com",
                    LocalDate.of(2000,12,20)
            );
            Student alex = new Student(

                    "Alex",
                    "alex@gmail.com",
                    LocalDate.of(2001,2,20)
            );

            studentRepository.saveAll(
                    List.of(maria,alex)
            );
        };
    }
}
