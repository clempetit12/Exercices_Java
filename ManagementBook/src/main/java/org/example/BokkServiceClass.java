package org.example;

import java.util.ArrayList;
import java.util.List;

public class BokkServiceClass implements BookService{
    @Override
    public  List<Book> filterBooksByAuthor(Author auteur, Book[] books) {
        List<Book> filteredBooks = new ArrayList<>();
        for (Book book : books) {
            for (Author bookAuthor : book.getAuteurs()) {
                if (bookAuthor.getId() == auteur.getId()) {
                    filteredBooks.add(book);
                }
            }
        }
        System.out.println("methode filterbookappelé");
        System.out.println("Livres filtrés par auteur : " + filteredBooks);

        return filteredBooks;
    }

    @Override
    public List<Book> filterBooksByPublisher(Publisher publish, Book[] books) {
        List<Book> filteredBooksByPublisher = new ArrayList<>();
        for (Book book : books) {
            if (book.getPublisher().getPublisherName().equals(publish.getPublisherName())) {
                filteredBooksByPublisher.add(book);
            }
        }
        System.out.println("Livres filtrés par publisher : " + filteredBooksByPublisher);
        return filteredBooksByPublisher;
    }

    @Override
    public List<Book> filterBooksAfterSpecifiedYear(int yearFromInclusively, Book[] books) {

        List<Book> filteredBooksAfterSpecifiedYear = new ArrayList<>();
        for (Book book: books) {
            if ( book.getPublishingAnnee() >= yearFromInclusively ) {
                filteredBooksAfterSpecifiedYear.add(book);
            }

        }
        System.out.println("Livres publiés après l'année " + yearFromInclusively+ " sont : " + filteredBooksAfterSpecifiedYear);
        return filteredBooksAfterSpecifiedYear;
    }
}
