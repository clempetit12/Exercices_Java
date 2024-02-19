package org.example.tp_blog.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
@EqualsAndHashCode
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comment", nullable = false)
    private int idComment;

    @NotBlank
    @NotNull(message = "nom non nul")
    @Size(min=3, message = "3 minimum svp")
    private String lastName;
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",message = "email non valide")
    private String email;
    @NotNull(message = "message non nul")
    private String content;
    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Post post;

}
