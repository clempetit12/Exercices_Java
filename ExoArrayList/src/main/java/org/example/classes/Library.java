package org.example.classes;

import java.time.LocalDate;
import java.util.ArrayList;

public class Library {

    public ArrayList<Book> bookList;
    public ArrayList<Emprunt> empruntList;

    public Library(ArrayList<Book> bookList, ArrayList<Emprunt> empruntList) {
        this.bookList = bookList;
        this.empruntList = empruntList;
    }

    public void addBook(Book book) {
        bookList.add(book);
    }



    public void findBookbyTitle(String title) {
        for (Book b : bookList) {
            if (title.equals(b.getTitle())) {
                System.out.println(b);
            }
        }
    }

    public void findBookbyAuthor(String author) {
        for (Book b : bookList) {
            if (author.equals(b.getAuthor())) {
                System.out.println(b);
            }
        }
    }
    public void removeBook(Book book) {
        int idBook = book.getId();
        Book foundBook = null;
        for (Book b:bookList) {
            if (idBook == b.getId()) {
                foundBook = b;
                break;
            }
        }
        if ((foundBook != null)) {
            bookList.remove(foundBook);
        }}

    public void empruntBook(Book book, Person person) {
        int bookId = book.getId();
        LocalDate dateChoisie = LocalDate.of(2023, 05, 28);
        boolean isBookAlreadyBorrowed = false;

        for (Emprunt e : empruntList) {
            if (bookId == e.getBook().getId()) {
                isBookAlreadyBorrowed = true;
                System.out.println("Vous ne pouvez pas emprunter ce livre, il est déjà emprunté.");
                break;
            }
        }


        if (!isBookAlreadyBorrowed) {
            Emprunt newEmprunt = new Emprunt(dateChoisie, dateChoisie.plusMonths(1), person, book);
            empruntList.add(newEmprunt);

        }
    }


    public void returnBook(Book book, LocalDate date) {
        Emprunt foundEmprunt = null;
        int bookId = book.getId();
        for (Emprunt e : empruntList) {
            if (bookId == e.getBook().getId()) {
                foundEmprunt = e;
            }
        }
          if (date.isAfter(foundEmprunt.getEndingDate())) {
              System.out.println("Vous avez dépassé la date vous serez facturé ");
            } else {
                empruntList.remove(foundEmprunt);
            }
        }


    }


