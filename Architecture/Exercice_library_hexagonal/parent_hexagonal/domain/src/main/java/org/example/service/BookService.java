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
        if(title.length() < 3) {
            throw new RuntimeException("Title length must be gt 3 char");
        }
        //...
        Book book = new Book.Builder().title(title).author(author).build();
        bookRepository.create(book);
        return book;
    }


    public Book getBookById(Long id) {
        Book book = bookRepository.findById(id);
        if (book != null) {
            return book;
        }
        throw new BookSearchException();
    }

    public boolean delete(Long id) {
        Book book = bookRepository.findById(id);
        if (bookRepository.delete(id)) {
            return true;
        }
        throw new BookSearchException();
    }

    public List<Book> getAllBooks() {
        List<Book> bookList = bookRepository.findAll();
        if (bookList != null) {
            return bookList;
        }
        throw new BookSearchException();
    }

    public List<Book> searchBook(String search) {
        if(search.length() < 3) {
            throw new RuntimeException("search word length must be gt 3 char");
        }
        return bookRepository.searchBook(search);
    }

}
