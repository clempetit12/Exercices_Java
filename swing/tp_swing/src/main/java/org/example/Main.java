package org.example;

import org.example.view.EmployeeUI;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                EmployeeUI employeeUI = new EmployeeUI();
            }
        });
    }
}