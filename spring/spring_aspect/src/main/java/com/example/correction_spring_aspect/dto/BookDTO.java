package com.example.correction_spring_aspect.dto;

import com.example.correction_spring_aspect.entity.Author;

public class BookDTO {
    private String name;
    private Author author;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
