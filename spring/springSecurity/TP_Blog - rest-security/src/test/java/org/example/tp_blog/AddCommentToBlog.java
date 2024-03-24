package org.example.tp_blog;

import org.example.tp_blog.controller.CommentController;
import org.example.tp_blog.controller.PostController;
import org.example.tp_blog.dto.CommentDto;
import org.example.tp_blog.dto.PostDto;
import org.example.tp_blog.service.CommentServiceImpl;
import org.example.tp_blog.service.PostServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AddCommentToBlog {

    private CommentController commentController;

    private BindingResult bindingResult ;
    @Mock
    private PostServiceImpl postService;
    @Mock
    private CommentServiceImpl commentService;
    @Mock
    private Model model;

    @BeforeEach
    void setUp() {
      commentController   = new CommentController(postService, commentService);
        bindingResult = new org.springframework.validation.BeanPropertyBindingResult(new CommentDto(), "commentDto");
    }

    @Test
    void testAddComment() {
        PostDto postDto = new PostDto();
        postDto.setId(1L);
        postDto.setTitle("Titre de l'article");
        postDto.setContent("Contenu de l'article");

        CommentDto commentDto = new CommentDto();
        commentDto.setLastName("Auteur du commentaire");
        commentDto.setContent("Contenu du commentaire");
        commentDto.setEmail("email@example.com");
        when(commentService.addCommentToPost(postDto,commentDto)).thenReturn(true);

        when(postService.getById(postDto.getId())).thenReturn(postDto);

        String viewName = commentController.addComment(commentDto, bindingResult, postDto.getId());

        assertEquals("redirect:/", viewName);
    }
}
