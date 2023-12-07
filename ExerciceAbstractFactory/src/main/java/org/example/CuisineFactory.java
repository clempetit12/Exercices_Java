package org.example;

import java.util.List;

public abstract class CuisineFactory {

    abstract public Ingredient createIngredient();
    abstract public CookingUstensil createUstensil();
    abstract public Dish createDish();
}
