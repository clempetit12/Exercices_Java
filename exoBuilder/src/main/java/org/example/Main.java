package org.example;

import org.example.classes.*;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> garnitures = new ArrayList<>();
        garnitures.add("mushrooms");
        garnitures.add("pepperoni");
        garnitures.add("ham");

        Pizza pizza = new Pizza.Builder().pastryType(PastryType.THICK).sauceType(SauceType.TOMATO).cheese(Cheese.MOZARELLA).build();
        System.out.println(pizza);
        Pizza pizza1 = new Pizza.Builder().pastryType(PastryType.THICK).sauceType(SauceType.TOMATO).cheese(Cheese.MOZARELLA).cheese(Cheese.CHEDDAR).build();
        System.out.println(pizza1);
    }
}