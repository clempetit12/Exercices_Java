package org.example;

public class Book {

    private int id;
    private String name;
    private Author[] auteurs;
    private Publisher publisher;
    private int publishingAnnee;
    private int amountOfPages;
    private double price;
    CoverType coverType;

    public Book(int id, String name, Author[] auteurs, Publisher publisher, int publishingAnnee, int amountOfPages, double price, CoverType coverType) {
        this.id = id;
        this.name = name;
        this.auteurs = auteurs;
        this.publisher = publisher;
        this.publishingAnnee = publishingAnnee;
        this.amountOfPages = amountOfPages;
        this.price = price;
        this.coverType = coverType;
    }


}
