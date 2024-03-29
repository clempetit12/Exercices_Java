package org.example.tp_blog.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.example.tp_blog.dto.CommentDto;
import org.example.tp_blog.dto.PostDto;

import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
@Entity
@ToString
@EqualsAndHashCode
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comment", nullable = false)
    private Long id;

    private String lastName;

    private String email;

    private String content;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public CommentDto toCommentDto() {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(this.id);
        commentDto.setLastName(this.lastName);
        commentDto.setPost(this.post);
        commentDto.setEmail(this.email);
        commentDto.setContent(this.content);
        return commentDto;
    }
}
