package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


       Restaurant restaurantItalien = new Restaurant(new ItalianCuisineFactory());
       restaurantItalien.runPlate();

    }
}