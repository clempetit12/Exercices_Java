package org.example.dao;

import jdk.jshell.spi.ExecutionControl;
import org.example.models.Customer;
import org.example.models.Location;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LocationDao extends BaseDao<Location> {
    public LocationDao(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Location element) throws SQLException {
        request = "INSERT INTO locations (location_name,adress,capacity ) VALUES (?, ?, ?) ";
        preparedStatement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, element.getname());
        preparedStatement.setString(2, element.getlocation());
        preparedStatement.setLong(3, element.getcapacity());
        int nbRows = preparedStatement.executeUpdate();
        resultSet = preparedStatement.getGeneratedKeys();
        if(resultSet.next()){
            element.setId(resultSet.getInt(1));
        }
        return nbRows>0;
    }

    @Override
    public boolean update(Location element) throws SQLException {
        request = "UPDATE  locations SET location_name  = ? , adress = ?, capacity = ? WHERE id_location = ? ";
        preparedStatement = _connection.prepareStatement(request);
        preparedStatement.setString(1, element.getname());
        preparedStatement.setString(2,element.getlocation() );
        preparedStatement.setLong(3,element.getcapacity() );
        preparedStatement.setLong(4,element.getId() );

        int nbRows = preparedStatement.executeUpdate();
        return nbRows>0;
    }

    @Override
    public boolean delete(Location element) throws SQLException {
        request = "DELETE FROM locations WHERE id_location = ?";
        preparedStatement = _connection.prepareStatement(request);
        preparedStatement.setInt(1, element.getId());
        int nbRows = preparedStatement.executeUpdate();
        return nbRows>0;
    }

    @Override
    public Location get(int id) throws SQLException {
        Location location = null;
        request = "SELECT * FROM locations WHERE id_location = ?";
        preparedStatement = _connection.prepareStatement(request);
        preparedStatement.setInt(1, id);
        resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            location = new Location(resultSet.getInt("id_location"),
                    resultSet.getString("location_name"),
                    resultSet.getString("adress"),
                    resultSet.getLong("capacity"));
        }
        return location;
    }

    @Override
    public List<Location> get() throws SQLException {
        List<Location> locationList = new ArrayList<>();
        request = "SELECT * FROM locations ";
        preparedStatement = _connection.prepareStatement(request);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Location location = new Location(resultSet.getInt("id_location"),
                    resultSet.getString("location_name"),
                    resultSet.getString("adress"),
                    resultSet.getLong("capacity"));
            locationList.add(location);
        }
        return locationList;
    }
}
