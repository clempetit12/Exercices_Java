package org.example;

import org.example.classes.*;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Pizza pizza = new Pizza.Builder().pastryType(PastryType.THICK).sauceType(SauceType.TOMATO).cheese(Cheese.MOZARELLA).garnitures("mushroom").build();
        System.out.println(pizza);
        Pizza pizza1 = new Pizza.Builder().pastryType(PastryType.THICK).sauceType(SauceType.TOMATO).cheese(Cheese.MOZARELLA).garnitures("peperonni").garnitures("ham").build();
        System.out.println(pizza1);
    }
}