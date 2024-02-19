package org.example.tp_blog.mapper;

import org.example.tp_blog.dto.CommentDto;
import org.example.tp_blog.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommentMapper {


    CommentDto commentToCommentDto(Comment comment);


    Comment commentDtoToComment(CommentDto commentDto);




}
