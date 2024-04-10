package org.example.view.dialog;

import org.example.dao.ContactDao;
import org.example.model.Contact;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateDialog extends JDialog {
    private JPanel contentPanel;

    private ContactDao contactDao;
    private JTextField txtName;
    private JTextField txtNumber;

    private JButton search;
    private JButton cancel;
    private JTextField id;

    public UpdateDialog() {
        contentPanel = new JPanel();
        setTitle("Update Contact Details");
        setBounds(100, 100, 350, 200);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        search = new JButton("Search");
        search.setBounds(180, 20, 80, 25);
        contentPanel.add(search);


        id = new JTextField();
        id.setBounds(80, 20, 80, 20);
        contentPanel.add(id);
        id.setColumns(10);

        txtNumber = new JTextField();
        txtNumber.setBounds(80, 80, 80, 20);
        contentPanel.add(txtNumber);
        txtNumber.setColumns(10);

        txtName = new JTextField();
        txtName.setBounds(80, 50, 80, 20);
        contentPanel.add(txtName);
        txtName.setColumns(20);

        JLabel labelId = new JLabel("ID");
        labelId.setBounds(10, 20, 50, 15);
        contentPanel.add(labelId);

        JLabel labelName = new JLabel("Name");
        labelName.setBounds(10, 50, 50, 15);
        contentPanel.add(labelName);

        JLabel labelNumber = new JLabel("Number");
        labelNumber.setBounds(10, 80, 50, 15);
        contentPanel.add(labelNumber);

        JPanel jPanelButton = new JPanel();
        jPanelButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(jPanelButton, BorderLayout.SOUTH);

        JButton jButton = new JButton("OK");


        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idText = id.getText();
                int contactId = Integer.parseInt(idText);
                ContactDao contactDao1 = new ContactDao();
                Contact foundContact = contactDao1.search(contactId);
                if (foundContact != null) {
                    txtName.setText(foundContact.getName());
                    txtNumber.setText(foundContact.getNumber());

                } else {
                    JOptionPane.showMessageDialog(null, "Record not found for given id !");
                }

            }
        });
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idText = id.getText();
                int contactId = Integer.parseInt(idText);
                Contact contactUpdate = new Contact();
                contactUpdate.setName(txtName.getText());
                contactUpdate.setNumber(txtNumber.getText());
                ContactDao contactDao1 = new ContactDao();
                int count = contactDao1.update(contactId,contactUpdate);
                if (count > 0) {
                    JOptionPane.showMessageDialog(null, "Record updated successfully !!");
                } else {
                    JOptionPane.showMessageDialog(null, "Record failed !!");
                }
                dispose();
            }
        });
        jPanelButton.add(jButton);

        JButton jButtonCancel = new JButton("Cancel");
        // contentPanel.add(jButtonCancel);
        jPanelButton.add(jButtonCancel);
        jButtonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

    }

}
