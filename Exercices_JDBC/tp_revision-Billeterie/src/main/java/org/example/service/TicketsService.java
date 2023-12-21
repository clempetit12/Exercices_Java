package org.example.service;

import jdk.jshell.spi.ExecutionControl;
import org.example.dao.CustomerDao;
import org.example.dao.EventDao;
import org.example.dao.LocationDao;
import org.example.models.Location;
import org.example.utils.DatabaseManager;

import java.sql.Connection;
import java.sql.SQLException;

public class TicketsService {

    private CustomerDao customerDao;
    private EventDao eventDao;
    private LocationDao locationDao;
    private Connection connection;


    public TicketsService() {

        try{
            connection = new DatabaseManager().getConnection();
            locationDao = new LocationDao(connection);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public boolean buyTicket(int idCustomer, int idEvent, int nombreTicketsBought) {
   return true;
    }

}

