package org.example.service;

import org.example.exception.BookCreationException;
import org.example.exception.BookSearchException;
import org.example.entity.Book;
import org.example.spi.port.BookRepository;

import java.util.List;

public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book create(String title, String author) {

        Book book = new Book(title, author);
        if (bookRepository.create(book)
        ) {
            return book;
        }
        throw new BookCreationException();
    }

    public Book getBookById(Long id) {
        Book book = bookRepository.findById(id);
        if(book != null) {
            return book;
        }
        throw new BookSearchException();
    }

    public boolean delete(Long id) {
        Book book = bookRepository.findById(id);
        if(bookRepository.delete(id)) {
            return true;
        }
        throw new BookSearchException();
    }

    public List<Book> getAllBooks() {
        List<Book> bookList = bookRepository.findAll();
        if(bookList != null) {
            return bookList;
        }
        throw new BookSearchException();
    }

}
