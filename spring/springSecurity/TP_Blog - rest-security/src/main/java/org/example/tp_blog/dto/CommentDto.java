package org.example.tp_blog.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.tp_blog.entity.Comment;
import org.example.tp_blog.entity.Post;

import java.util.UUID;

@Data
@AllArgsConstructor
public class CommentDto {

    private int id;


    @NotNull
  @Size(min = 3)
    private String lastName;
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",message = "email non valide")
    private String email;
    @NotNull
    private String content;
    private Post post;

    public CommentDto() {
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Comment toComment() {
        Comment comment = new Comment();
        comment.setId(id);
     comment.setContent(content);
     comment.setPost(post);
     comment.setEmail(email);
     comment.setLastName(lastName);
        return comment;
    }

}
