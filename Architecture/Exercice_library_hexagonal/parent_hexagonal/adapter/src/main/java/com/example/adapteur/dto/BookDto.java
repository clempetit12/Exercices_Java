package com.example.adapteur.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.Book;
import org.example.entity.BookEntity;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    Long id;
    String title;
    String author;

    public BookEntity toEntity() {
        return BookEntity.builder().title(title).author(author).build();
    }
}