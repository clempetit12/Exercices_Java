package org.example.tp_blog.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@EqualsAndHashCode
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @NotBlank
    @NotNull(message = "titre non nul")
    @Size(min=3, message = "3 minimum svp")
    private String title;
    private String content;
    @NotNull(message = " non nul")
    private String description;
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Comment> commentList;


}
