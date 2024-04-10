package org.example.view.dialog;

import org.example.dao.ContactDao;
import org.example.model.Contact;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteDialog extends JDialog {

    private JPanel contentPanel;

    private ContactDao contactDao;
    private JTextField txtName;
    private JTextField txtNumber;

    private JButton search;
    private JButton cancel;
    private JTextField id;

    public DeleteDialog() {

    contentPanel = new JPanel();
    setTitle("Delete Contact");
    setBounds(100, 100, 350, 200);
    getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);


    id = new JTextField();
        id.setBounds(80, 20, 80, 20);
        contentPanel.add(id);
        id.setColumns(10);

    JLabel labelId = new JLabel("ID");
        labelId.setBounds(10, 20, 50, 15);
        contentPanel.add(labelId);


    JPanel jPanelButton = new JPanel();
        jPanelButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
    getContentPane().add(jPanelButton, BorderLayout.SOUTH);

    JButton jButton = new JButton("OK");


        jButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String idText = id.getText();
            int contactId = Integer.parseInt(idText);
            ContactDao contactDao1 = new ContactDao();
            Contact foundContact = contactDao1.search(contactId);
            if (foundContact != null) {
               contactDao1.deleteContact(foundContact.getId());

                JOptionPane.showMessageDialog(null, "Record deleted !", "Message", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(null, "Contact not found", "Message", JOptionPane.INFORMATION_MESSAGE);
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
