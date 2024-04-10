package org.example;

import org.example.view.EmployeeUI;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        EmployeeUI mainFrame = new EmployeeUI();
                        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        mainFrame.setSize(600, 400);
                        mainFrame.setTitle("Main Frame");
                        mainFrame.setLocationRelativeTo(null);
                        mainFrame.setVisible(true);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
