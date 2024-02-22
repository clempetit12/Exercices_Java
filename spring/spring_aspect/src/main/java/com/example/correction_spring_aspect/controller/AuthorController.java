package com.example.correction_spring_aspect.controller;

import com.example.correction_spring_aspect.dto.AuthorDto;
import com.example.correction_spring_aspect.dto.BookDTO;
import com.example.correction_spring_aspect.entity.Author;
import com.example.correction_spring_aspect.entity.Book;
import com.example.correction_spring_aspect.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("authors")
public class AuthorController {

    private final BookService bookService;

    public AuthorController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Author> save(@RequestBody AuthorDto authorDto) {
        Author author = bookService.save(authorDto.getFirstName(), authorDto.getLastName());
        return ResponseEntity.ok(author);

    }

}
