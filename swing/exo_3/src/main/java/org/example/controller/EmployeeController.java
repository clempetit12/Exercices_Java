package org.example.controller;

import org.example.dao.EmployeeDAO;
import org.example.model.Employee;

import java.util.List;

public class EmployeeController {

    private EmployeeDAO employeeDAO = new EmployeeDAO();

    public boolean createEmployee(Employee employee) {
        int employee1 = employeeDAO.addEmployee(employee);
        if(employee1 >0) {
            return true;
        }
        return false;
    }



    public Employee searchEmployee(int id) {
        Employee employee = employeeDAO.search(id);
        if(employee != null) {
            return employee;
        }
        return null;
    }

    public boolean updateEmployee(int id, Employee employee) {
        employeeDAO.updateEmployee(id,employee);
        return true;
    }

    public boolean deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
        return true;
    }

    public List<Employee> displayAll() {
       return employeeDAO.display();
    }

    public List<Employee> getEmployeeByDepartmentId(int id) {
        return employeeDAO.getEmployeeByDepartmentId(id);
    }




}
