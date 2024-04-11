package org.example.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private int employeeId;

    private String name;

    private boolean gender;

    private int age;

    private String bloodGroup;

    private String contactNumber;

    private LocalDate startDate;

    private String adress;

    private String urlImage;









}
