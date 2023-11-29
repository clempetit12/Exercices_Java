package org.example.classes;

import java.util.HashMap;

public  abstract class Article {


    public static long count = 1;
    public long id;

    public static HashMap<Long,Article> bdd = new HashMap<>();



    static {
        count++;
    }

    public Article() {
        this.id = count++;
        bdd.put(this.id, this);


    }

    public static long getCount() {
        return count;
    }

    public static void setCount(long count) {
        Article.count = count;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public static HashMap<Long, Article> getBdd() {
        return bdd;
    }

    public static void setBdd(HashMap<Long, Article> bdd) {
        Article.bdd = bdd;
    }

    public static Article getArticle(double idArticle) {
        return bdd.get(idArticle);
    }

    public abstract double getPrice();
    public abstract String  getName();


    @Override
    public String toString() {
        return
                "référence article =" + id + " ";
    }
}
