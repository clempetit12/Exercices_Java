package org.example;

import java.util.List;

public class MexicanCuisineFactory extends CuisineFactory {

    @Override
    public Ingredient createIngredient() {
        return new MexicanIngredient();
    }

    @Override
    public CookingUstensil createUstensil() {
        return new MexicanCookingUstensil();
    }

    @Override
    public Dish createDish() {
        return new MexicanDish();
    }
}
