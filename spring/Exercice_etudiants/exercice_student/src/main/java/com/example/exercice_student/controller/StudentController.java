package com.example.exercice_student.controller;

import com.example.exercice_student.entity.Student;
import com.example.exercice_student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class StudentController {


    private final StudentService studentService;

    @GetMapping
    public String showHome() {
        return "home";
    }

    @GetMapping(value = "/list")
    public String showAllStudents(Model model) {
        List<Student> studentList = studentService.getAll();
        model.addAttribute("students", studentList);
        return "studentList";

    }
    @GetMapping(value = "/detail/{studentId}")
    public String showStudent(@PathVariable("studentId") UUID id, Model model) {
        Student student = studentService.getById(id);
        model.addAttribute("student", student);
        return "student";

    }

}


