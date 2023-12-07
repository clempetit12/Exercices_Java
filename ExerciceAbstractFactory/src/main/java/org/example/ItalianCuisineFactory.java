package org.example;

import java.util.ArrayList;
import java.util.List;

public class ItalianCuisineFactory extends CuisineFactory {

    @Override
    public Ingredient createIngredient() {
        return new ItalianIngredient();
    }

    @Override
    public CookingUstensil createUstensil() {
        return new ItalianCookingUstensil();
    }

    @Override
    public Dish createDish() {
        return new ItalianDish();
    }


}
