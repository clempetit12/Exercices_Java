package org.example.tp_blog.controller;

import jakarta.validation.Valid;
import org.example.tp_blog.dto.PostDto;
import org.example.tp_blog.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/posts")
public class PostRestController {

    @Autowired
    private PostServiceImpl postService;
    private String location = "upload-dir";



    @PostMapping("post")
    public  void  createPost(@ModelAttribute("post") @Valid PostDto postDto, @RequestParam("image") MultipartFile image) throws IOException {
        postDto.setImage(image);
        String imageName = image.getOriginalFilename();
        Path destinationFile = Paths.get(location).resolve(Paths.get(imageName)).toAbsolutePath();
        InputStream stream = image.getInputStream();
        Files.copy(stream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
        postService.savePostWithImage(postDto,image);

    }

    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts() {
        return ResponseEntity.ok(postService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Long id) {
        PostDto postDto = postService.getById(id);
        if (postDto != null) {
            return ResponseEntity.ok(postDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto) {
        return ResponseEntity.ok(postService.update(postDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
      postService.delete(id);
        return ResponseEntity.ok().build();
    }

}
