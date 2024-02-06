package org.example.spi.port;

import org.example.entity.Book;

import java.util.List;

public interface BookRepository {

    boolean create(Book book);

    boolean delete(Long id);

    boolean update(Book book);

    Book findById(Long id);

    List<Book> findAll();
    List<Book> searchBook(String search);
}
