package org.example.tp_blog.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.tp_blog.dto.PostDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Builder
@AllArgsConstructor
@Entity
@ToString
@EqualsAndHashCode
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String title;

    private String content;
    private String description;
    @Column(name = "image_url", length = 1000)
    private String image;
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Comment> commentList;

    public Post(String title, String content, String description, String image) {
        this.title = title;
        this.content = content;
        this.description = description;
        this.image = image;
        this.commentList = new ArrayList<>();
    }

    public Post() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public PostDto toPostDto() {
        PostDto postDto = new PostDto();
        postDto.setId(this.id);
        postDto.setTitle(this.title);
        postDto.setContent(this.content);
        postDto.setDescription(this.description);
        postDto.setImageUrl(this.image);
        postDto.setCommentList(this.commentList);
        return postDto;
    }
}