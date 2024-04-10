package org.example.controller;

import org.example.dao.EmployeeDAO;
import org.example.model.Employee;

public class EmployeeController {

    private EmployeeDAO employeeDAO;

    public boolean createEmployee(Employee employee) {
        employeeDAO = new EmployeeDAO();
        int employee1 = employeeDAO.addEmployee(employee);
        if(employee1 >0) {
            return true;
        }
        return false;
    }



}
