package org.example.classes;

public class ArticleUnitaire extends Article {

   protected String name;

   protected int price;


    public ArticleUnitaire(String name, int price) {
        this.name = name;
        this.price = price;
    }


    @Override
    public String getName() {
        return  this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
return this.price = price;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", prix unitaire =" + price + " ";
    }
}
