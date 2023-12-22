package org.example.dao;

import jdk.jshell.spi.ExecutionControl;
import org.example.models.Customer;
import org.example.models.Event;
import org.example.models.Location;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EventDao extends BaseDao<Event> {
    public EventDao(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Event element) throws SQLException{
        request = "INSERT INTO events (event_name,date_event,hour_event,id_location,price,number_tickets_sold ) VALUES (?, ?, ?, ?, ?, ?) ";
        preparedStatement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, element.getname());
        preparedStatement.setDate(2, new java.sql.Date(element.getDate().getTime()));
        preparedStatement.setTime(3, new java.sql.Time(element.getDate().getTime()));
        preparedStatement.setInt(4, element.getIdLocation());
        preparedStatement.setFloat(5, element.getprice());
        preparedStatement.setInt(6, element.getnumberticketsSold());
        int nbRows = preparedStatement.executeUpdate();
        resultSet = preparedStatement.getGeneratedKeys();
        if(resultSet.next()){
            element.setId(resultSet.getInt(1));
        }
        return nbRows>0;
    }

    @Override
    public boolean update(Event element) throws SQLException {
        request = "UPDATE  events SET event_name  = ? , date_event = ?, hour_event = ?, id_location = ?, price = ?, number_tickets_sold = ?  WHERE id_event = ? ";
        preparedStatement = _connection.prepareStatement(request);
        preparedStatement.setString(1, element.getname());
        preparedStatement.setDate(2, new java.sql.Date(element.getDate().getTime()));
        preparedStatement.setTime(3, new java.sql.Time(element.getDate().getTime()));
        preparedStatement.setInt(4, element.getIdLocation());
        preparedStatement.setFloat(5, element.getprice());
        preparedStatement.setInt(6, element.getnumberticketsSold());
        preparedStatement.setInt(7, element.getId());
        int nbRows = preparedStatement.executeUpdate();
        return nbRows>0;
    }

    @Override
    public boolean delete(Event element) throws SQLException {
        request = "DELETE FROM events WHERE id_event = ?";
        preparedStatement = _connection.prepareStatement(request);
        preparedStatement.setInt(1, element.getId());
        int nbRows = preparedStatement.executeUpdate();
        return nbRows>0;
    }

    @Override
    public Event get(int id) throws SQLException {
        Event event = null;
        request = "SELECT * FROM events WHERE id_event = ?";
        preparedStatement = _connection.prepareStatement(request);
        preparedStatement.setInt(1, id);
        resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            event = new Event(resultSet.getInt("id_event"), resultSet.getString("event_name"),
            resultSet.getDate("date_event"),resultSet.getTime("hour_event"),
            resultSet.getInt("id_location"),resultSet.getFloat("price"),
                    resultSet.getInt("number_tickets_sold"));
        }
        return event;
    }

    @Override
    public List<Event> get() throws SQLException {
        List<Event> eventList = new ArrayList<>();
        request = "SELECT * FROM events ";
        preparedStatement = _connection.prepareStatement(request);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Event  event = new Event(resultSet.getInt("id_event"), resultSet.getString("event_name"),
                    resultSet.getDate("date_event"),resultSet.getTime("hour_event"),
                    resultSet.getInt("id_location"),resultSet.getFloat("price"),
                    resultSet.getInt("number_tickets_sold"));
            eventList.add(event);
        }
        return eventList;
    }

public List<Event> getEventsAvailable() throws SQLException {
    List<Event> eventListAvailable = new ArrayList<>();
    request = " SELECT id_event, event_name, capacity, number_tickets_sold FROM events INNER JOIN locations " +
            "ON locations.id_location = events.id_location WHERE (capacity - number_tickets_sold) > 0";
    preparedStatement = _connection.prepareStatement(request);
    resultSet = preparedStatement.executeQuery();
    while (resultSet.next()){
        Event  event = new Event(resultSet.getInt("id_event"), resultSet.getString("event_name"),
                resultSet.getInt("number_tickets_sold"));
        eventListAvailable.add(event);
    }
    return eventListAvailable;
    }

    public boolean updateEventTicketsSold(Event element) throws SQLException {
        request = "UPDATE  events SET  number_tickets_sold = ?  WHERE id_event = ? ";
        preparedStatement = _connection.prepareStatement(request);
        preparedStatement.setInt(1, element.getnumberticketsSold());
        preparedStatement.setInt(2, element.getId());
        int nbRows = preparedStatement.executeUpdate();
        return nbRows>0;
    }

}
