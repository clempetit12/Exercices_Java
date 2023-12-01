package org.example.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;

@Data


public class Location {
    private String name;
    private String address;
    private long capacity;

    private static HashMap<String, Location> locationsList = new HashMap<>();

    public Location(String name, String address, long capacity) {
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        locationsList.put(name, this);
    }

    ;

    public static Location getLocation(String name) {
        return locationsList.get(name);
    }

    public static int nbLocation() {
        return locationsList.size();
    }


    public static void modifyLocation(String name, String newAddress, long newCapacity) {
        Location locationUpdate = locationsList.get(name);

        if (locationUpdate != null) {
            locationUpdate.setAddress(newAddress);
            locationUpdate.setCapacity(newCapacity);
            System.out.println("Lieu modifié avec succès !");
        } else {
            System.out.println("Lieu non trouvé. La modification a échoué.");
        }
    }
    public static void displayAllLocations() {

        for (Location location : locationsList.values()) {
            System.out.println(location);
        }}

        public static void deleteLocation(String name) {
            Location locationToDelete = locationsList.get(name);

            if (locationToDelete != null) {
               locationsList.remove(name);
                System.out.println("Lieu a été supprimé avec succès !");

            } else {
                System.out.println("Lieu non trouvé. La suppression a échoué.");
            }
        }

}
