package org.example.component;

import lombok.Getter;
import lombok.Setter;
import org.example.entity.Task;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.Map;

@Getter
@Setter
public class TaskList {

    private JPanel mainPanel;
    private JPanel panelList;
    private JTextField input;
private JPanel buttons;
    private JButton add;
    private JButton delete;
    private JButton complete;
    private JPanel tablePanel;
    private DefaultListModel list;
    private JList taskList;
    private JTable table;


    public TaskList() {
        mainPanel = new JPanel(new BorderLayout());

        TitledBorder formBorder = BorderFactory.createTitledBorder("TodoList");
        mainPanel.setBorder(formBorder);

        input = new JTextField(15);
        mainPanel.add(input,BorderLayout.NORTH);

        list = new DefaultListModel<>();
        taskList = new JList<>(list);
        mainPanel.add(taskList,BorderLayout.CENTER);

        buttons = new JPanel(new FlowLayout());
       add = new JButton("Add");
       add.addActionListener(e -> addTask());
        add.setIcon(new ImageIcon("C:\\Users\\Administrateur\\Desktop\\Exercices_Java\\swing\\exo_todolist\\src\\main\\java\\org\\example\\assets\\icons8-ajouter-32.png"));


       delete = new JButton("Delete");
        delete.addActionListener(e -> deleteTask());
        delete.setIcon(new ImageIcon("C:\\Users\\Administrateur\\Desktop\\Exercices_Java\\swing\\exo_todolist\\src\\main\\java\\org\\example\\assets\\icons8-supprimer-30.png"));


        complete = new JButton("Complete");
        complete.addActionListener(e -> completeTask());
        complete.setIcon(new ImageIcon("C:\\Users\\Administrateur\\Desktop\\Exercices_Java\\swing\\exo_todolist\\src\\main\\java\\org\\example\\assets\\icons8-done-26.png"));

        buttons.add(add);
        buttons.add(delete);
        buttons.add(complete);
        mainPanel.add(buttons,BorderLayout.SOUTH);
    }

    private void completeTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            String todoToStrike = (String) list.getElementAt(selectedIndex);
            if (!todoToStrike.startsWith("<html>")) {
                todoToStrike = "<html><strike>" + todoToStrike + "</strike></html>";
                list.set(selectedIndex, todoToStrike);
            } else {

            }
            taskList.repaint();
        }
    }





    private void deleteTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            list.removeElementAt(selectedIndex);
        }
    }

    private void addTask() {
        String name = input.getText();
        Task task = new Task(name);
        System.out.println(name);
        list.addElement(name);
        System.out.println(list);
        taskList.repaint();

    }
}
