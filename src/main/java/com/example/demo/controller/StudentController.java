package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.model.Teacher;
import com.example.demo.repos.StudentRepository;
import com.example.demo.repos.TeacherRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    public StudentController(StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }



    @GetMapping("/student")
    public List<Student> fetchAllStudents(){
        return studentRepository.findAll();
    }


    // Post
    @CrossOrigin(origins = "*", exposedHeaders = "Location")
    @PostMapping("/student/post")
    public ResponseEntity<String> create(@ModelAttribute Student s){
        Teacher teacher = teacherRepository.findById(s.getTeacherId()).get();
        s.setTeacher(teacher);

        Student student = studentRepository.save(s);
        return ResponseEntity.status(201).header("Location", "/student/" + student.getId()).body("{'Msg': 'student created'}");
    }

    // Update

    @PutMapping("/student/edit")
    public ResponseEntity<String> update(@ModelAttribute Student student){

        System.out.println(student);
        studentRepository.save(student);
        return ResponseEntity.status(204).body("{'msg':'Hello'}");
    }

    @DeleteMapping("/student/delete")
    public ResponseEntity<String> deleteStudent(@ModelAttribute Student s){
        System.out.println("delete test controller");
        System.out.println(s);
        studentRepository.deleteById(s.getId());
        return ResponseEntity.status(200).body("{'msg':'Deleted'}");
    }


}
