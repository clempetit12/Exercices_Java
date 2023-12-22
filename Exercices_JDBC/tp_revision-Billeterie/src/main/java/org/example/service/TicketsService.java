package org.example.service;

import jdk.jshell.spi.ExecutionControl;
import org.example.dao.CustomerDao;
import org.example.dao.EventDao;
import org.example.dao.LocationDao;
import org.example.dao.TicketsSalesDao;
import org.example.models.Customer;
import org.example.models.Event;
import org.example.models.Location;
import org.example.models.Tickets;
import org.example.utils.DatabaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TicketsService {

    private CustomerDao customerDao;
    private EventDao eventDao;
    private LocationDao locationDao;
    private Connection connection;
    private TicketsSalesDao ticketsSalesDao;
    private EventService eventService = new EventService();


    public TicketsService() {

        try {
            connection = new DatabaseManager().getConnection();
            locationDao = new LocationDao(connection);
            customerDao = new CustomerDao(connection);
            ticketsSalesDao = new TicketsSalesDao(connection);
            eventDao = new EventDao(connection);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean buyTickets(Tickets tickets) {
        try {
            Event event = eventService.getEventById(tickets.getIdEvent());
            if (eventService.verifyDisponibilityEvent(event,tickets)) {
                    return ticketsSalesDao.buyTicketsForEvent(tickets);
                } else {
                    System.out.println("Il n'y a plus de places disponibles !");
                }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }


    public boolean cancelTicket(int id) {
        try {
            ticketsSalesDao.cancelTicket(id);
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Tickets getTicketById(int id) {
        try {
            return ticketsSalesDao.getTicketsSales(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Tickets> getTicketBoughtByCustomer(int id) {
        try {
            return ticketsSalesDao.getTicketsBoughtByCustomer(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

