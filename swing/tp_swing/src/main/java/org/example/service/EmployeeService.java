package org.example.service;

import org.example.dao.EmployeeDao;
import org.example.model.Employee;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService {

    private EmployeeDao employeeDao;

    public EmployeeService() {
        employeeDao = new EmployeeDao();
    }

    public boolean createEmployee(Employee employee) {
        if (employeeDao.addEmployee(employee) > 0) {
            return true;
        }

        return false;
    }

    public boolean updateEmployee(Employee employee) throws SQLException {
        employeeDao.updateEmployee(employee);
        return true;
    }

    public void deleteEmploye( int id) {
        employeeDao.deleteEmployee(id);
    }

    public Employee getEmployee(int id) {
        return employeeDao.getEmployee(id);
    }

    public List<Employee> getAll() {
        return employeeDao.displayAll();
    }

    public Employee searchEmployee(String text) {
        return employeeDao.searchEmployee( text);
    }

}
