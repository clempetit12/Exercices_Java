package org.example.entity;

import java.util.List;

public class Product {

    private String name;
    private int sellin;
    private int quality;
    private String category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int setSellingDays(int sellin) {
        this.sellin = sellin;
        return sellin;
    }

    public int setQuality(int quality) {
        if (quality < 0) {
            throw new RuntimeException("La qualité ne peut pas être négative");
        } else if (quality > 50) {
            throw new RuntimeException("La qualité ne peut pas être supérieure à 50");
        }
        return this.quality = quality;
    }

    public int getSellin() {
        return sellin;
    }

    public int getQuality() {
    return quality;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int increaseQuality() {
        if (name.equals("Brie Vieilli") && quality < 50) {
            quality = quality + 1;
            return quality;
        }
        return quality;
    }

    public int qualityEvolution() {
        if (sellin == 0) {
            quality = quality / 2;
        } else {
            if (category.equals("Milk")) {
                quality = quality / 2;
            } else {
                quality = quality - 1;
            }
        }
        return quality;
    }

}
