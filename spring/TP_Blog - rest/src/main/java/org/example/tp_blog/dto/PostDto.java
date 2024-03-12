package org.example.tp_blog.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.tp_blog.entity.Comment;
import org.example.tp_blog.entity.Post;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor

public class PostDto {

    private int id;

    private String title;

    private String content;
    private String description;
    private List<Comment> commentList;
    private MultipartFile image;
    private String imageUrl;

    public PostDto() {
    }


    public PostDto(String title, String content, String description) {
        this.title = title;
        this.content = content;
        this.description = description;
        this.commentList = new ArrayList<>();
    }

    public PostDto(int id, String title, String content, String description) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.description = description;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public MultipartFile getImage() {
        return image;
    }



    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }


    public Post toPost() {
        Post post = new Post();
        post.setId(id);
        post.setTitle(title);
        post.setContent(content);
        post.setDescription(description);
        post.setImage(convertMultipartFileToString(image));
        post.setCommentList(commentList);
        return post;
    }
    public static String convertMultipartFileToString(MultipartFile file) {
       String filename = file.getOriginalFilename().toString();
       return filename;
    }
}
