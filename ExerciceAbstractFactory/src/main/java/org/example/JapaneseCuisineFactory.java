package org.example;

import java.util.List;

public class JapaneseCuisineFactory extends CuisineFactory {

    @Override
    public Ingredient createIngredient() {
        return new JapaneseIngredient();
    }

    @Override
    public CookingUstensil createUstensil() {
        return new JapaneseCookingUstensil();
    }

    @Override
    public Dish createDish() {
        return new JapaneseDish();
    }
}