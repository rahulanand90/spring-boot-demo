package com.coderahul.springbootdemo.controllers;

import com.coderahul.springbootdemo.models.Student;
import com.coderahul.springbootdemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudent(@PathVariable Long id){
        return studentRepository.findById(id);
    }

    @GetMapping("/all")
    public List<Student> getStudent(){
        return (List<Student>) studentRepository.findAll();
    }

}
