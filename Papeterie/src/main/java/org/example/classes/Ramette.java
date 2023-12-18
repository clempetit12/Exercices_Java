package org.example.classes;

public class Ramette extends ArticleUnitaire {
    int grammage;


    public Ramette(String id, String name, int price, int grammage) {
        super(id, name, price);
        this.grammage = grammage;
    }

    public int getGrammage() {
        return grammage;
    }

    public void setGrammage(int grammage) {
        this.grammage = grammage;
    }


    public String toString() {
        return super.toString()+"Ramette{" +
                "grammage=" + grammage +
                '}';
    }
}
