package org.example.boutique_bonbons.dto;

import jakarta.persistence.Id;

public class CandyDto {



    private Long id;

    private String name;
    private String description;
    private String magicalEffect;

    private int stock;
    private double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMagicalEffect() {
        return magicalEffect;
    }

    public void setMagicalEffect(String magicalEffect) {
        this.magicalEffect = magicalEffect;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
