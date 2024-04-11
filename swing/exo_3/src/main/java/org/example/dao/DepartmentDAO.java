package org.example.dao;

import org.example.controller.EmployeeController;
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

public class DepartmentDAO {

    private Connection con;
    private ResultSet rs;


    private PreparedStatement ps;

    public int addDepartment(Department department) {
        con = ConnexionDB.getConnection();
        try {
            ps = con.prepareStatement("INSERT INTO `department`(`name`) values(?)");
            ps.setString(1, department.getName());

            return ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public int updateDepartment(int id, Department department) {
        con = ConnexionDB.getConnection();
        try {

            EmployeeController employeeController = new EmployeeController();
            List<Employee> employees = employeeController.getEmployeeByDepartmentId(department.getId());
             for (Employee e : employees) {
                 e.setDepartmentId(id);
                 employeeController.updateEmployee(e.getId(),e);
             }
            ps = con.prepareStatement("UPDATE department SET name = ? WHERE id = ?");
            ps.setString(1, department.getName());
            ps.setInt(2, id);
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

    public Department search(int id) {
        Department department = null;
        try {
            con = ConnexionDB.getConnection();
            ps = con.prepareStatement("SELECT name FROM department WHERE id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                department = new Department();
                department.setId(rs.getInt("id"));
                department.setName(rs.getString("name"));


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

        return department;
    }


    public int deleteDepartment(int id) {
        con = ConnexionDB.getConnection();
        try {
            ps = con.prepareStatement("DELETE  FROM department WHERE id = ?");
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public List<Department> display() {
        List<Department> departments = new ArrayList<>();
        ResultSet rs = null;

        try {
            con = ConnexionDB.getConnection();
            ps = con.prepareStatement("SELECT d.id, d.name, COUNT(e.id) AS employee_count " +
                    "FROM department d " +
                    "LEFT JOIN employee e ON d.id = e.departmentId " +
                    "GROUP BY d.id, d.name");
            rs = ps.executeQuery();

            while (rs.next()) {
                Department department = new Department();
                department.setId(rs.getInt("id"));
                department.setName(rs.getString("name"));
                departments.add(department);

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

        return departments;
    }

}
