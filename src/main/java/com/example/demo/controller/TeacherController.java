package com.example.demo.controller;

import com.example.demo.repos.TeacherRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {

    private final TeacherRepository repository;


    public TeacherController(TeacherRepository repository) {
        this.repository = repository;
    }
}
