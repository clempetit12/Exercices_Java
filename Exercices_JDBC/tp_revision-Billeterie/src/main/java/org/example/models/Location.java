package org.example.models;

public class Location {

    private int id;
    private String name;
    private String location;
    private Long capacity;

    public Location(String name, String location, Long capacity) {
        this.name = name;
        this.location = location;
        this.capacity = capacity;
    }

    public Location(int id, String name, String location, Long capacity) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getlocation() {
        return location;
    }

    public void setlocation(String location) {
        this.location = location;
    }

    public Long getcapacity() {
        return capacity;
    }

    public void setcapacity(Long capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Lieu{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
