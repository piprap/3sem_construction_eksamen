package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/add-student")
    public String addStudent(){
        return "add-student";
    }


    @GetMapping("/add-teacher")
    public String addTeacher(){
        return "add-teacher";
    }

    //Some wierd naming.
    @GetMapping("/about-contact")
    public String aboutContact(){
        return "about-contact";
    }

}
