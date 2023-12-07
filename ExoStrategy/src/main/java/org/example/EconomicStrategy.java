package org.example;

public class EconomicStrategy implements NavigationStrategy {
    @Override
    public boolean navigate(String destination) {
        System.out.println("Utilisation navigation économique");
        return true;
    }
}
