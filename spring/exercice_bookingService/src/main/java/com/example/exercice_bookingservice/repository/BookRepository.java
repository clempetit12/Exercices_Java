package com.example.exercice_bookingservice.repository;

import com.example.exercice_bookingservice.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;



@RepositoryRestResource(path = "books", collectionResourceRel = "books")
public interface BookRepository extends CrudRepository<Book, Long> {

    //http://localhost:8080/books/search/searchTitle?title=miserables
    @RestResource(path = "searchTitle")
    List<Book> findAllByTitleContaining(@Param("title") String title );









}
