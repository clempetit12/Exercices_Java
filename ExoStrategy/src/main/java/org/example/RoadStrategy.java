package org.example;

public class RoadStrategy implements NavigationStrategy {
    @Override
    public boolean navigate(String destination) {
        System.out.println("Utilisation navigation Road");
        return true;
    }
}
