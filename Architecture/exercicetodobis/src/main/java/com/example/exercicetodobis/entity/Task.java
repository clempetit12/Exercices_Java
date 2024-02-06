package com.example.exercicetodobis.entity;

import com.example.exercicetodobis.dto.TaskDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_task", nullable = false)
    private Long idTask;

    private boolean status;

    private String content;
    public TaskDto toDto() {
        return TaskDto.builder().id(idTask).content(content).status(status).build();
    }


}
