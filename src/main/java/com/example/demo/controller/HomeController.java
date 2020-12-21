package com.example.demo.controller;

import com.example.demo.model.Teacher;
import com.example.demo.model.*;
import com.example.demo.repos.StudentRepository;
import com.example.demo.repos.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    StudentRepository studentRepository;


    @GetMapping("/")
    public String index(Model model){
        Iterable<Teacher> teacherList = teacherRepository.findAll();
        Iterable<Student> studentList = studentRepository.findAll();
        model.addAttribute("teachers", teacherList);
        model.addAttribute("students", studentList);
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
