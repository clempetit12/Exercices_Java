package org.example.classes;

public class Lot extends Article {


    private Article article;
    int quantity;
    double discount;

    public Lot(String id, String idArticle, int quantity, double discount) {
        super(id);
        this.article = Article.getArticle(idArticle);
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

    @Override
    public String getName() {
        return article.getName();
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
        if (article != null){
            double prix = (article.getPrice())*quantity;
            double prixDiscount = (prix*(1-discount));
            return prixDiscount ;
        }
     else {
         return 0.0;
        }
    }

    @java.lang.Override
    public java.lang.String toString() {
        return super.toString() + "Lot{" +
                "article=" + article +
                ", quantity=" + quantity +
                ", discount=" + discount +
                '}';
    }
}
