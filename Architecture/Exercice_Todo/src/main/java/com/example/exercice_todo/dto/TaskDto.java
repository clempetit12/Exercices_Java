package com.example.exercice_todo.dto;

import com.example.exercice_todo.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for {@link com.example.todolist.entity.Todo}
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    Long id;
    String content;
    boolean status;

    public Task toEntity() {
        return Task.builder().content(content).status(status).build();
    }
}