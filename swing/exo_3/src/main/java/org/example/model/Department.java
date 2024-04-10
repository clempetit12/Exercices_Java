package org.example.model;

import lombok.Data;

import java.util.List;

@Data
public class Department {

    int id;
private String name;
private List<Employee> employee;


}
