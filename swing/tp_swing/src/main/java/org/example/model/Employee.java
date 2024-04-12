package org.example.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

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

    private Qualification qualification;

    private LocalDate startDate;

    private String adress;

    private String urlImage;

    public Employee(String name, boolean gender, int age, String bloodGroup, String contactNumber, Qualification qualification, LocalDate startDate, String adress, String urlImage) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.bloodGroup = bloodGroup;
        this.contactNumber = contactNumber;
        this.qualification = qualification;
        this.startDate = startDate;
        this.adress = adress;
        this.urlImage = urlImage;
    }
}
