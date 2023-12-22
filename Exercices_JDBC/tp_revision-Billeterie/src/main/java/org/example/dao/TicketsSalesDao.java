package org.example.dao;


import org.example.models.Tickets;

import java.lang.ref.PhantomReference;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketsSalesDao {
private Connection _connection;
private PreparedStatement preparedStatement;
    protected String request;
    protected ResultSet resultSet;

    public TicketsSalesDao(Connection connection) {
        this._connection = connection;
    }

    public boolean buyTicketsForEvent(Tickets element) throws SQLException {
        request = "INSERT INTO tickets_sales (id_customer,id_event,numberTicketsBought ) VALUES (?, ?, ?) ";
        preparedStatement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1,element.getIdCustomer() );
        preparedStatement.setInt(2, element.getIdEvent());
        preparedStatement.setInt(3, element.getNumberTicketsBought());
        int nbRows = preparedStatement.executeUpdate();
        resultSet = preparedStatement.getGeneratedKeys();
        if(resultSet.next()){
            element.setId(resultSet.getInt(1));
        }
        return nbRows>0;
    }

    public boolean cancelTicket(int id) throws SQLException{
        request = "DELETE FROM tickets_sales WHERE id_tickets_sales = ? ";
        preparedStatement = _connection.prepareStatement(request);
        preparedStatement.setInt(1, id);
        int nbRows = preparedStatement.executeUpdate();
        return nbRows>0;
    }

    public Tickets getTicketsSales(int id) throws SQLException {
        Tickets tickets = null;
        request = "SELECT * FROM tickets_sales WHERE id_tickets_sales = ?";
        preparedStatement = _connection.prepareStatement(request);
        preparedStatement.setInt(1, id);
        resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            tickets = new Tickets(resultSet.getInt("id_tickets_sales"),
                    resultSet.getInt("id_customer"),
                    resultSet.getInt("id_event"),
                    resultSet.getInt("numberTicketsBought"));

        }
        return tickets;
    }

    public List<Tickets> getTicketsBoughtByCustomer(int id) throws SQLException {
        List<Tickets> ticketsList = new ArrayList<>();
        request = "SELECT * FROM tickets_sales WHERE id_customer = ?";
        preparedStatement = _connection.prepareStatement(request);
        preparedStatement.setInt(1, id);
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            Tickets tickets = new Tickets(resultSet.getInt("id_tickets_sales"),
                    resultSet.getInt("id_customer"),
                    resultSet.getInt("id_event"),
                    resultSet.getInt("numberTicketsBought"));
            ticketsList.add(tickets);

        }

        return ticketsList;
    }
}
