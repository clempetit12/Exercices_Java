package org.example;

import java.util.List;

public class Restaurant {

private Ingredient ingredients;
private CookingUstensil cookingUstensils;
private Dish dish;

private CuisineFactory cuisineFactory;
public Restaurant (CuisineFactory cuisineFactory) {
setCuisineFactory(cuisineFactory);

}
public void setCuisineFactory(CuisineFactory cuisineFactory) {
    this.cuisineFactory = cuisineFactory;
    ingredients = this.cuisineFactory.createIngredient();
    cookingUstensils = this.cuisineFactory.createUstensil();
    dish = this.cuisineFactory.createDish();
}
    public void runPlate() {
        ingredients.prepare();
        cookingUstensils.use();
        dish.serve();
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "ingredients=" + ingredients +
                ", cookingUstensils=" + cookingUstensils +
                ", dish=" + dish +
                '}';
    }
}
