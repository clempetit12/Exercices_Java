package org.example.repository;


import org.example.entity.Book;
import org.example.entity.BookEntity;
import org.example.spi.port.BookRepository;
import org.example.utils.HibernateSession;
import org.hibernate.Session;

import java.util.List;
import java.util.stream.Collectors;

public class BookEntityRepositoryImpl implements BookRepository {

    private BookEntityRepository bookEntityRepository;

    public BookEntityRepositoryImpl() {
        bookEntityRepository = new BookEntityRepository();
    }


    @Override
    public boolean create(Book book) {
        Session session = HibernateSession.getSessionFactory().openSession();
        bookEntityRepository.setSession(session);
        session.beginTransaction();
        try {
            BookEntity bookEntity = BookEntity.builder().
                    title(book.getTitle()).
                    author(book.getAuthor()).build();
            bookEntityRepository.create(bookEntity);
            session.getTransaction().commit();
            book.setIdBook(bookEntity.getId());
            return true;

        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }

    }

    @Override
    public boolean delete(Long id) {
        Session session = HibernateSession.getSessionFactory().openSession();
        bookEntityRepository.setSession(session);
        session.beginTransaction();
        try {
            BookEntity bookEntity = bookEntityRepository.findById(id);
            if (bookEntity != null) {
                bookEntityRepository.delete(bookEntity);
            }
            session.getTransaction().commit();
            return true;

        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public boolean update(Book book) {
        Session session = HibernateSession.getSessionFactory().openSession();
        bookEntityRepository.setSession(session);
        session.beginTransaction();
        try {
            BookEntity bookEntity = BookEntity.builder().
                    title(book.getTitle()).
                    author(book.getAuthor()).build();
            bookEntityRepository.create(bookEntity);
            session.getTransaction().commit();
            return true;

        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public Book findById(Long id) {
        Session session = HibernateSession.getSessionFactory().openSession();
        bookEntityRepository.setSession(session);
        session.beginTransaction();
        try {
            BookEntity bookEntity = bookEntityRepository.findById(id);
            if (bookEntity != null) {
                Book book = bookEntity.toBook();
                return book;
            }
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
        return null;
    }

    @Override
    public List<Book> findAll() {
        Session session = HibernateSession.getSessionFactory().openSession();
        bookEntityRepository.setSession(session);
        session.beginTransaction();
        try {
            List<BookEntity> bookEntityList = bookEntityRepository.fildAll();
            List<Book> bookList = bookEntityList.stream().map(bookEntity -> bookEntity.toBook())
                    .collect(Collectors.toList());

            return bookList;
        } catch (
                Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

    public List<Book> findAllByKey(String key) {
        Session session = HibernateSession.getSessionFactory().openSession();
        bookEntityRepository.setSession(session);
        session.beginTransaction();
        try {
            List<BookEntity> bookEntityList = bookEntityRepository.findAllByKey(key);
            List<Book> bookList = bookEntityList.stream().map(bookEntity -> bookEntity.toBook())
                    .collect(Collectors.toList());
            return bookList;
        } catch (
                Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
    }




}
