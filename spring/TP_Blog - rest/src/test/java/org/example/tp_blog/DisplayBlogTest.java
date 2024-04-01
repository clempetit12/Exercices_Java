package org.example.tp_blog;

import org.example.tp_blog.controller.PostController;
import org.example.tp_blog.dto.PostDto;
import org.example.tp_blog.entity.Post;
import org.example.tp_blog.service.PostServiceImpl;
import org.example.tp_blog.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DisplayBlogTest {

    private PostController postController;

    private UserService userService;

    @Mock
    private PostServiceImpl postService;

    @Mock
    private Model model;

    @BeforeEach
    void setUp() {
        postController = new PostController(postService,userService);
    }

    @Test
    void testHomePage() {
        List<PostDto> posts = new ArrayList<>();
        posts.add(new PostDto( "Title 1", "Description 1", "description"));
        posts.add(new PostDto("Title 2", "Description 2", "description"));
        when(postService.getAll()).thenReturn(posts);

        String viewName = postController.home(model);

        assertEquals("home", viewName);
        Mockito.verify(model).addAttribute("posts", posts);
    }
}
