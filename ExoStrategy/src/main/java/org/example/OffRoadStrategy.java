package org.example;

public class OffRoadStrategy implements NavigationStrategy {
    @Override
    public boolean navigate(String destination) {
        System.out.println("Utilisation navigation OffRoad");
        return true;
    }
}
