package org.example.tp_blog.mapper;

import org.example.tp_blog.dto.CommentDto;
import org.example.tp_blog.dto.PostDto;
import org.example.tp_blog.entity.Comment;
import org.example.tp_blog.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostMapper {

    PostDto postToPostDto(Post post);


    Post postDtoToPost(PostDto postDto);

}
