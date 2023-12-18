package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book {

    protected int id;
    protected String name;
    protected Author[] auteurs;
    protected Publisher publisher;
    protected int publishingAnnee;
    protected int amountOfPages;
    protected BigDecimal price;
    CoverType coverType;


    public Book() {
    }

    public Book(int id, String name, Author[] auteurs, Publisher publisher, int publishingAnnee, int amountOfPages, BigDecimal price, CoverType coverType) {
        this.id = id;
        this.name = name;
        this.auteurs = auteurs;
        this.publisher = publisher;
        this.publishingAnnee = publishingAnnee;
        this.amountOfPages = amountOfPages;
        this.price = price;
        this.coverType = coverType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author[] getAuteurs() {
        return auteurs;
    }

    public void setAuteurs(Author[] auteurs) {
        this.auteurs = auteurs;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public int getPublishingAnnee() {
        return publishingAnnee;
    }

    public void setPublishingAnnee(int publishingAnnee) {
        this.publishingAnnee = publishingAnnee;
    }

    public int getAmountOfPages() {
        return amountOfPages;
    }

    public void setAmountOfPages(int amountOfPages) {
        this.amountOfPages = amountOfPages;
    }



    public CoverType getCoverType() {
        return coverType;
    }

    public void setCoverType(CoverType coverType) {
        this.coverType = coverType;
    }



    @java.lang.Override
    public java.lang.String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", auteurs=" + java.util.Arrays.toString(auteurs) +
                ", publisher=" + publisher +
                ", publishingAnnee=" + publishingAnnee +
                ", amountOfPages=" + amountOfPages +
                ", price=" + price +
                ", coverType=" + coverType +
                '}';
    }
}
