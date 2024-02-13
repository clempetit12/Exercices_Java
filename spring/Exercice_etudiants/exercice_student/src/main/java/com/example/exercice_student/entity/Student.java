package com.example.exercice_student.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {

    private UUID id;

    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private Image image;


}
