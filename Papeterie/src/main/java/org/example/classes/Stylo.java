package org.example.classes;

public class Stylo extends ArticleUnitaire{

    String color;


    public Stylo(String id, String name, int price, String color) {
        super(id, name, price);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    @Override
    public String toString() {
        return super.toString()+ " couleur :"+ color;
    }
}
