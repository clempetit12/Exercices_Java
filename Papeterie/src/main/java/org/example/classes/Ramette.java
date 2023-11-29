package org.example.classes;

public class Ramette extends ArticleUnitaire {
    int grammage;

    public Ramette(String name, int price, int grammage) {
        super(name, price);
        this.grammage = grammage;
    }

    public int getGrammage() {
        return grammage;
    }

    public void setGrammage(int grammage) {
        this.grammage = grammage;
    }

    @Override
    public String toString() {
        return super.toString() + "Ramette : " +
                ", name='" + name + '\'' + " ";
    }
}
