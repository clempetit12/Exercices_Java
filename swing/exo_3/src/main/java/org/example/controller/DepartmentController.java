package org.example.controller;


import org.example.dao.DepartmentDAO;
import org.example.dao.EmployeeDAO;
import org.example.model.Department;
import org.example.model.Employee;
import org.example.model.Role;
import org.example.utils.ConnexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentController {

    private DepartmentDAO departmentDAO;

    public List<Department> displayAll() {
        departmentDAO = new DepartmentDAO();
        return departmentDAO.display();
    }



}
