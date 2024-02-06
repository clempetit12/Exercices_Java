package org.example.entity;

import java.util.Locale;

public class Book {

    private Long idBook;
    private String title;
    private String author;

    public Book() {
    }

    private Book(Builder builder) {
        this.idBook = builder.idBook;
        this.title = builder.title;
        this.author = builder.author;
    }

    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public static class Builder {

        private Long idBook;
        private String title;
        private String author;

        public Builder idBook(Long idBook) {
            this.idBook = idBook;
            return this;

        }
        public Builder title(String title) {
            this.title = title;
            return this;

        }
        public Builder author(String author) {
            this.author = author;
            return this;

        }
        public Book build() {
            return new Book(this);
        }

    }


}
