package com.example.exercice_todo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Task {

    private int id;
    private String title;

    private String description;
    private boolean done;
}
