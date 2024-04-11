package org.example.dao;

import org.example.controller.DepartmentController;
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

public class EmployeeDAO {
   private Connection con;
  private  ResultSet rs;


    private PreparedStatement ps;

    public int addEmployee(Employee employee) {
        con = ConnexionDB.getConnection();
        try {
            ps = con.prepareStatement("INSERT INTO `employee`(`firstName`,`lastName`,`role`, `departmentId`)values(?,?,?,?)");
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setString(3, String.valueOf(employee.getRole()));
            ps.setInt(4, employee.getDepartmentId());

            return ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public int updateEmployee(int id, Employee employee) {
        con = ConnexionDB.getConnection();
        try {
            ps = con.prepareStatement("UPDATE employee SET firstName = ?,lastName = ?,  role = ?, departmentId = ? WHERE id = ?");
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setString(3, String.valueOf(employee.getRole()));
            ps.setInt(4, employee.getDepartmentId());
            ps.setInt(5, id);
            return ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Employee search(int id) {
        Employee employee = null;
        try {
            con = ConnexionDB.getConnection();
            ps = con.prepareStatement("SELECT id, firstName,lastName, role, departmentId FROM employee WHERE id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setFirstName(rs.getString("firstName"));
                employee.setLastName(rs.getString("lastName"));
                employee.setRole(Role.valueOf(rs.getString("role")));
                employee.setDepartmentId(rs.getInt("departmentId"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return employee;
    }


    public int deleteEmployee(int id) {
        con = ConnexionDB.getConnection();
        try {
            ps = con.prepareStatement("DELETE  FROM employee WHERE id = ?");
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public List<Employee> display() {
        List<Employee> employees = new ArrayList<>();
        ResultSet rs = null;

        try {
            con = ConnexionDB.getConnection();
            ps = con.prepareStatement("SELECT * FROM `employee`");
            rs = ps.executeQuery();

            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setFirstName(rs.getString("firstName"));
                employee.setLastName(rs.getString("lastName"));
                employee.setRole(Role.valueOf(rs.getString("role")));
                employee.setDepartmentId(rs.getInt("departmentId"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return employees;
    }

    public List<Employee> getEmployeeByDepartmentId(int id) {
        List<Employee> employees = new ArrayList<>();
        ResultSet rs = null;

        try {
            con = ConnexionDB.getConnection();
            ps = con.prepareStatement("SELECT * FROM `employee` WHERE id = ?");
            ps.setInt(1, id);

            rs = ps.executeQuery();

            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setFirstName(rs.getString("firstName"));
                employee.setLastName(rs.getString("lastName"));
                employee.setRole(Role.valueOf(rs.getString("role")));
                employee.setDepartmentId(rs.getInt("departmentId"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return employees;
    }









}
