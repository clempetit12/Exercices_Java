package org.example.dao;

import org.example.connexion.ConnectionUtil;
import org.example.model.Contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactDao {


    Connection con;

    private PreparedStatement ps;

    public int addContact(Contact contact) {
        con = ConnectionUtil.getConnection();
        try {
            ps = con.prepareStatement("INSERT INTO `contact`(`name`,`number`)values(?,?)");
            ps.setString(1, contact.getName());
            ps.setString(2, contact.getNumber());

            return ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public int update(int id, Contact contact) {
        con = ConnectionUtil.getConnection();
        try {
            ps = con.prepareStatement("UPDATE contact SET name = ?, number = ? WHERE id = ?");
            ps.setString(1, contact.getName());
            ps.setString(2, contact.getNumber());
            ps.setInt(3, id);
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

    public Contact search(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Contact contact = null;

        try {
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement("SELECT name, id, number FROM contact WHERE id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                contact = new Contact();
                contact.setId(rs.getInt("id"));
                contact.setName(rs.getString("name"));
                contact.setNumber(rs.getString("number"));
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

        return contact;
    }





    public int deleteContact(int id) {
        con = ConnectionUtil.getConnection();
        try {
            ps = con.prepareStatement("DELETE  FROM contact WHERE id = ?");
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public List<Contact> display() {
        List<Contact> contacts = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement("SELECT * FROM `contact`");
            rs = ps.executeQuery();

            while (rs.next()) {
                Contact contact = new Contact();
                contact.setId(rs.getInt("id"));
                contact.setName(rs.getString("name"));
                contact.setNumber(rs.getString("number"));
                contacts.add(contact);
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

        return contacts;
    }



}





