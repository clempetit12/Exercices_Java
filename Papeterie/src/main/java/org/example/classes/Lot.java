package org.example.classes;

public class Lot extends Article {

    Article article;
    int quantity;
    double discount;

    public Lot(Article article, int quantity, double discount) {
        this.article = article;
        this.quantity = quantity;
        this.discount = discount;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public double getPrice() {
        double prix = (article.getPrice())*quantity;
        double prixDiscount = (prix*(1-discount));
        return prixDiscount ;
    }


    @Override
    public String toString() {
        return  super.toString() + "Lot : " +
                " quantity=" + quantity +
                " discount=" + discount +
                '}';
    }
}
