package org.example;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        Book[] books =new Book[] {
            new Book(1, "Book_1", new Author[] { new Author(1, "Jon", "Johnson") }, new Publisher(1, "Publisher_1"), 1990, 231, BigDecimal.valueOf(24.99), CoverType.PAPERBACK),
                new Book(2, "Book_2", new Author[] { new Author(1, "Jon", "Johnson"), new Author(2, "William", "Wilson") }, new Publisher(2, "Publisher_2 "), 2000, 120, BigDecimal.valueOf(14.99), CoverType.PAPERBACK),
                new Book(3, "Livre_3", new Author[] {new Author(3, "Walter", "Peterson") }, new Publisher(1, "Publisher_1"), 1997, 350, BigDecimal.valueOf(34.99), CoverType.HARDCOUVERTURE),
            new Book( 4, "Book_4", new Author[] { new Author(4, "Craig", "Gregory") }, new Publisher(3, "Publisher_3"), 1992, 185, BigDecimal.valueOf(19.99), CoverType.PAPERBACK) } ;

        Author authorFilter = new Author(1,"Jon","Johnson");
        Publisher publisher = new Publisher(3,"Publisher_3");

        BokkServiceClass bookService = new BokkServiceClass();
        List<Book> filteredBookByAuthor = bookService.filterBooksByAuthor(authorFilter, books);
List<Book> filteredBookByPublisher = bookService.filterBooksByPublisher(publisher,books);
        List<Book> filteredBooksAfterSpecifiedYear = bookService.filterBooksAfterSpecifiedYear(1997,books);

    }

    }



