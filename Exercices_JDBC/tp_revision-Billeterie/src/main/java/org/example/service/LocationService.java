package org.example.service;

import jdk.jshell.spi.ExecutionControl;
import org.example.dao.CustomerDao;
import org.example.dao.EventDao;
import org.example.dao.LocationDao;
import org.example.models.Customer;
import org.example.models.Location;
import org.example.utils.DatabaseManager;

import java.sql.Connection;
import java.sql.SQLException;

public class LocationService {


    private LocationDao locationDao;
    private Connection connection;

    public LocationService() {
        try {
            connection = new DatabaseManager().getConnection();
            locationDao = new LocationDao(connection);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Location createAndSaveLocation(String locationName, String adress, Long capacity) {
        Location location = new Location(locationName, adress, capacity);
        try {
            if (locationDao.save(location)) {
                System.out.println("Un lieu a bien été créé avec l'id : " + location.getId());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return location;
    }

    public Location updateLocation(Location location) {
        try {
            locationDao.update(location);
            return location;

        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteLocation(int id) {
        try {
            Location location = locationDao.get(id);
            if (location != null) {
                locationDao.delete(location);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public Location getLocationById(int id) {
        try {
            return locationDao.get(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
