package org.example;

public class ItalianIngredient extends Ingredient {

    @Override
    void prepare() {
        System.out.println("Italian prepare");
    }
}
