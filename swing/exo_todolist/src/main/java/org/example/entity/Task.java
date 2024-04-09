package org.example.entity;

import lombok.Data;

@Data

public class Task {

    String name;

    public Task(String name) {
        this.name = name;
    }

    public void setCompleted(boolean b) {
    }
}
