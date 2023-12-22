package org.example.service;

import org.example.dao.CustomerDao;
import org.example.dao.EventDao;
import org.example.dao.LocationDao;
import org.example.models.Customer;
import org.example.models.Event;
import org.example.models.Location;
import org.example.models.Tickets;
import org.example.utils.DatabaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;
import java.util.List;

public class EventService {

    private EventDao eventDao;
    private LocationDao locationDao;
    private Connection connection;

    public EventService() {

        try{
            connection = new DatabaseManager().getConnection();
            locationDao = new LocationDao(connection);
            eventDao = new EventDao(connection);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Event createAndSaveEvent(String eventName, Date dateEvent, Time timeEvent, int idLocation, float price, int numberTicketsSold) {
        Event event = new Event(eventName,dateEvent,timeEvent,idLocation,price,numberTicketsSold);
        try {
            if (eventDao.save(event)) {
                System.out.println("Un évènement a bien été créé avec id : " + event.getId() );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return event;
    }

    public boolean updateEvent(Event event) {
        try {
          eventDao.update(event);
            return true ;

        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteEvent(int id) {
        try {
            Event event = eventDao.get(id);
            if (event != null) {
                eventDao.delete(event);
                System.out.println("Event avec id " + id + " supprimé avec succès.");
            } else {
                System.out.println("Event avec id " + id + " n'existe pas.");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

    public Event getEventById(int id) {
        try {
            return eventDao.get(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Event> getAvailableEvents() {
        try {
            return eventDao.getEventsAvailable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean verifyDisponibilityEvent(Event event, Tickets tickets) {
        try {
            Location location = locationDao.get(event.getIdLocation());
            int numberTicketsAvailable = event.getnumberticketsSold();
            if (location.getcapacity() >= numberTicketsAvailable + tickets.getNumberTicketsBought()) {
                return true;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public boolean updateeventTicketsSold(Event event) {
        try {
            return eventDao.updateEventTicketsSold(event);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
