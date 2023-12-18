package org.example.classes;

import java.util.HashMap;

public  abstract class Article {



private String id;
    private static HashMap<String,Article> bdd = new HashMap<>();


    protected Article(String id) {
        this.id = id;
        bdd.put(id,this);
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static HashMap<String, Article> getBdd() {
        return bdd;
    }

    public static void setBdd(HashMap<String, Article> bdd) {
        Article.bdd = bdd;
    }

    public static Article getArticle(String idArticle) {
        return bdd.get(idArticle);
    }

    public abstract double getPrice();
    public abstract String  getName();


    @java.lang.Override
    public java.lang.String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                "nom= " + getName() + "prix unitaire= " + getPrice()+
                '}';
    }
}
