package org.example;

import org.example.component.Table;
import org.example.component.Form;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Demo Layout");
        jFrame.setSize(400, 850);
        jFrame.setLocationRelativeTo(null);


        Table table = new Table();

        Form form = new Form(table);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        mainPanel.add(form.getPanel());


        mainPanel.add(table.getPanel());

        jFrame.add(mainPanel);
        jFrame.setVisible(true);

    }
}