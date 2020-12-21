package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.repos.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

@RestController
public class StudentController {

    private final StudentRepository studentRepository;


    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }



    @GetMapping("/student")
    public List<Student> fetchAllStudents(){
        return studentRepository.findAll();
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Optional<Student>> fetchStudent(@PathVariable long id){
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            return ResponseEntity.status(200).body(student);
        } else {
            return ResponseEntity.status(404).body(student);
        }
    }

    // Post
    @CrossOrigin(origins = "*", exposedHeaders = "Location")
    @PostMapping("/student")
    public ResponseEntity<String> create(@ModelAttribute Student s){
        Student student = studentRepository.save(s);
        return ResponseEntity.status(201).header("Location", "/student/" + student.getId()).body("{'Msg': 'student created'}");
    }

    // Update

    @PutMapping("/student")
    public ResponseEntity<String> update(@ModelAttribute Student student){
        studentRepository.save(student);
        return ResponseEntity.status(204).body("{'msg':'Hello'}");
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable long id){
        studentRepository.deleteById(id);
        return ResponseEntity.status(200).body("{'msg':'Deleted'}");
    }


}
