package com.example.exercice_student.service;

import com.example.exercice_student.entity.Student;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@org.springframework.stereotype.Service
public class StudentService implements Service<Student> {

    private final Map<UUID, Student> students;

    private String imagePath;


    public StudentService() {
        students = new HashMap<>();
        Student student = Student.builder().id(UUID.randomUUID()).firstName("Hélène").lastName("Patard").age(30).email("helenepatard@gmail.com").build();
        Student student2 = Student.builder().id(UUID.randomUUID()).firstName("Olivia").lastName("Pigani").age(28).email("oliviapigani@gmail.com").build();
        Student student3 = Student.builder().id(UUID.randomUUID()).firstName("Pauline").lastName("Laout").age(30).email("paulinelaout@gmail.com").build();

        students.put(student.getId(), student);
        students.put(student2.getId(), student2);
        students.put(student3.getId(), student3);


    }

    @Override
    public List<Student> getAll() {
        return students.values().stream().toList();
    }

    @Override
    public Student getById(UUID id) {
        return students.values().stream().filter(student -> student.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public boolean add(String firstName, String lastName, int age, String email) {
        Student student = Student.builder().firstName(firstName)
                .lastName(lastName)
                .email(email)
                .age(age).id(UUID.randomUUID()).build();
        students.put(student.getId(), student);
        return true;
    }

    @Override
    public List<Student> getByLastNameOrFirstName(String name) {
        return students.values().stream().filter(student -> student.getLastName().toLowerCase().contains(name.toLowerCase()) ||
                student.getFirstName().toLowerCase().contains(name.toLowerCase())).toList();
    }

    @Override
    public boolean deleteStudent(Student student) {
        if (students.remove(student.getId(), student)) {
            return true;
        }
        ;
        return false;
    }

    @Override
    public Student update(UUID id, Student student) {
        Student student1 = getById(id);
        student1.setFirstName(student.getFirstName());
        student1.setLastName(student.getLastName());
        student1.setAge(student.getAge());
        student1.setEmail(student.getEmail());
        return student1;
    }


}
