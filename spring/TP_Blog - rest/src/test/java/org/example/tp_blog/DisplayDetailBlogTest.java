
package org.example.tp_blog;

import org.example.tp_blog.controller.PostController;
import org.example.tp_blog.dto.PostDto;
import org.example.tp_blog.service.PostServiceImpl;
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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DisplayDetailBlogTest {

    private PostController postController;

    @Mock
    private PostServiceImpl postService;

    @Mock
    private Model model;

    @BeforeEach
    void setUp() {
        postController = new PostController(postService);
    }

    @Test
    void testDetailBlog() {
        List<PostDto> posts = new ArrayList<>();
        PostDto postDto = new PostDto( 1,"Title 1", "Description 1", "hello");
        posts.add(postDto);
        when(postService.getById(1)).thenReturn(postDto);

        String viewName = postController.showDetail(1,model);

        assertEquals("detail", viewName);
        Mockito.verify(model).addAttribute("post", postDto);
    }
}

