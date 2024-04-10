package org.example.view.dialog;

import org.example.dao.ContactDao;
import org.example.model.Contact;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DisplayDialog extends JDialog {

    private JPanel contentPanel;

    private ContactDao contactDao;
    private JTextField txtName;
    private JTextField txtNumber;

    private JButton search;
    private JButton cancel;
    private JTextField id;


    public DisplayDialog() {
        contentPanel = new JPanel();
        setTitle("Display Contacts");
        setBounds(100, 100, 350, 200);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        String[] columnNames = {"ID", "Name", "Number"};
        ContactDao contactDao1 = new ContactDao();
        List<Contact> contacts = contactDao1.display();
        Object[][] data = new Object[contacts.size()][3];
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            data[i][0] = contact.getId();
            data[i][1] = contact.getName();
            data[i][2] = contact.getNumber();
        }

        JTable table = new JTable(data, columnNames);
        table.setBounds(100, 100, 500, 300);
        table.setPreferredScrollableViewportSize(new Dimension(500, 200));
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);


        JPanel jPanelButton = new JPanel();
        jPanelButton.setLayout(new FlowLayout(FlowLayout.CENTER));
        getContentPane().add(jPanelButton, BorderLayout.SOUTH);

        JButton jButton = new JButton("OK");

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        jPanelButton.add(jButton);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
    }
}


