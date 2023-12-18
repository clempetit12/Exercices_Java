package org.example;

public class EconomicStrategy implements NavigationStrategy {

    private Destination destinationEnum;

    @Override
    public boolean navigate(String destination) {

            System.out.println("Utilisation navigation économique pour aller à " + destination);
            return true;
    }
}
