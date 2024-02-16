package org.example.tp_blog.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    private UUID id;
    @NotBlank
    @NotNull(message = "titre non nul")
    @Size(min=3, message = "3 minimum svp")
    private String title;
    private String content;
    @NotNull(message = " non nul")
    private String description;
    private List<Comment> commentList;


}
