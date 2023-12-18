package org.example.classes;
import org.example.classes.Article;
import org.example.classes.ArticleUnitaire;
public class Ligne {

    Article article;
    int quantityBought;

    public Ligne(Article article, int quantityBought) {
        this.article = article;
        this.quantityBought = quantityBought;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public int getQuantityBought() {
        return quantityBought;
    }

    public void setQuantityBought(int quantityBought) {
        this.quantityBought = quantityBought;
    }

    public void afficheToi() {
        if (article != null) {
            System.out.printf("%6s | %10s | %10s | %10s | %10s | %n",
                    quantityBought,
                    article.getId(),
                    article.getName(),
                    article.getPrice(),
            ( article.getPrice())*quantityBought);
        } else {
            System.out.println("Article is null");
        }
    }


    @Override
    public String toString() {
        return quantityBought + " " + article;
    }

}
