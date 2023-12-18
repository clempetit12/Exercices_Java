package org.example;

import java.util.ArrayList;
import java.util.List;

public interface BookService {

    public  List<Book> filterBooksByAuthor(Author auteur, Book[] books);

    public  List<Book> filterBooksByPublisher(Publisher publisher, Book[] books);

    public  List<Book> filterBooksAfterSpecifiedYear(int YearFromInclusively, Book[] books);





}
