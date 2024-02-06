package com.example.exercicetodobis.dto;

import com.example.exercicetodobis.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 }
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