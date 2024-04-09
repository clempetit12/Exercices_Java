package org.example;

import org.example.component.TaskList;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Demo Layout");
        jFrame.setSize(400, 850);
        jFrame.setLocationRelativeTo(null);
        jFrame.setLayout(new BorderLayout());
jFrame.add(new TaskList().getMainPanel());
        jFrame.setVisible(true);
    }
}