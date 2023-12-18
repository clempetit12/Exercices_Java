package org.example;

public class OffRoadStrategy implements NavigationStrategy {
    @Override
    public boolean navigate(String destination) {
        System.out.println("Utilisation navigation OffRoad pour aller à " + destination);
        return true;
    }
}
