package com.example.adapteur.resource;

import com.example.adapteur.dto.BookDto;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.entity.Book;
import org.example.repository.BookEntityRepositoryImpl;
import org.example.service.BookService;

import java.util.List;
import java.util.stream.Collectors;

@Path("books")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    private final BookService bookService;


    @Inject
    public BookResource() {
        bookService = new BookService(new BookEntityRepositoryImpl());
    }

    @GET
    public List<BookDto> getAll() {
        List<Book> bookList = bookService.getAllBooks();
        return bookList.stream()
                .map(book -> {
                    return BookDto.builder()
                            .id(book.getIdBook())
                            .title(book.getTitle())
                            .author(book.getAuthor())
                            .build();
                })
                .collect(Collectors.toList());
    }


    @POST
    public Book post(BookDto bookDto) {
        String title = bookDto.getTitle();
        String author = bookDto.getAuthor();
        return bookService.create(title, author);
    }

    @GET
    @Path("{id}")
    public Book get(@PathParam("id") Long id) {
        return bookService.getBookById(id);
    }
    @DELETE
    @Path("{id}")
    public boolean delete(@PathParam("id") Long id) {
        return bookService.delete(id);
    }


}
