package com.example.correction_spring_aspect.service;

import com.example.correction_spring_aspect.annotation.Log;
import com.example.correction_spring_aspect.annotation.Performance;
import com.example.correction_spring_aspect.annotation.Transactional;
import com.example.correction_spring_aspect.entity.Author;
import com.example.correction_spring_aspect.entity.Book;
import com.example.correction_spring_aspect.repository.AuthorRepository;
import com.example.correction_spring_aspect.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Performance
    @Transactional
    public Book save(String name, Author author) {
        Optional<Author> optionalAuthor = authorRepository.findById(author.getId());
        if (optionalAuthor.isPresent()) {
            Book book = new Book();
            book.setName(name);
            book.setAuthor(author);
            return bookRepository.save(book);

        }

        return null;
    }

    @Performance
    @Log
    public Book findById(long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            return optionalBook.get();
        }
        throw new RuntimeException("Not found");
    }

    @Log
    public List<Book> findAll() {
        List<Book> books = (List<Book>) bookRepository.findAll();
        return books;
    }

    public Author save(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        authorRepository.save(author);
        return author;
    }
}
