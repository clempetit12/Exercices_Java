package com.example.exercice_student.controller;

import com.example.exercice_student.entity.Student;
import com.example.exercice_student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/students")
public class StudentRestController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getAll();
    }

}
