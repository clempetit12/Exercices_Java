package com.example.exercice_student.service;

import com.example.exercice_student.entity.Student;

import java.util.List;
import java.util.UUID;

public interface Service<T> {

    public List<T> getAll();
    public T getById(UUID id);

    public boolean add(String firstName,String lastName, int age, String email);

    public List<T> getByLastNameOrFirstName(String name);
    public boolean deleteStudent(Student student);

    public Student update(T element);


}