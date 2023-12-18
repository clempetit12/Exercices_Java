package org.example.classes;

import java.time.LocalDate;

public class Emprunt {

    private LocalDate startDate;

    private LocalDate endingDate;

    private Person person;

    private Book book;

    public Emprunt(LocalDate startDate, LocalDate endingDate, Person person, Book book) {
        this.startDate = startDate;
        this.endingDate = endingDate;
        this.person = person;
        this.book = book;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(LocalDate endingDate) {
        this.endingDate = endingDate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Emprunt{" +
                "startDate=" + startDate +
                ", endingDate=" + endingDate +
                ", person=" + person +
                ", book=" + book +
                '}';
    }
}
