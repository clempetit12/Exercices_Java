package org.example.view.dialog;

import org.example.dao.ContactDao;
import org.example.model.Contact;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertDialog extends JDialog {

    private JPanel contentPanel;
    private JTextField txtName;
    private JTextField txtNumber;

    public InsertDialog(){
        contentPanel = new JPanel();
        setTitle("Insertion Contact");
        setBounds(100,100, 350,200);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5,5,5,5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        txtNumber = new JTextField();
        txtNumber.setBounds(80, 50,80, 20);
        contentPanel.add(txtNumber);
        txtNumber.setColumns(10);

        txtName = new JTextField();
        txtName.setBounds(80, 20,80, 20);
        contentPanel.add(txtName);
        txtName.setColumns(20);

        JLabel labelName = new JLabel("Name");
        labelName.setBounds(10,20,50,15);
        contentPanel.add(labelName);

        JLabel labelNumber = new JLabel("Number");
        labelNumber.setBounds(10,50,50,15);
        contentPanel.add(labelNumber);

        JPanel jPanelButton = new JPanel();
        jPanelButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(jPanelButton, BorderLayout.SOUTH);

        JButton jButton = new JButton("OK");

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Contact contact = new Contact();
                contact.setName(txtName.getText());
                contact.setNumber(txtNumber.getText());
                ContactDao contactDao = new ContactDao();
                int count = contactDao.addContact(contact);
                if(count>0){
                    JOptionPane.showConfirmDialog(null, "Operation succeed");
                }else{
                    JOptionPane.showConfirmDialog(null, "Operation Failed");
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
