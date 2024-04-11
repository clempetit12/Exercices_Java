package org.example.service;

import org.example.dao.EmployeeDao;
import org.example.model.Employee;

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

    public void updateEmployee(Employee employee) {
        employeeDao.updateEmployee(employee);
    }

    public void deleteEmploye( int id) {
        employeeDao.deleteEmployee(id);
    }

    public Employee getEmployee(int id) {
        return employeeDao.searchEmployee(id);
    }

    public List<Employee> getAll() {
        return employeeDao.displayAll();
    }

}
