package org.example.todospring.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.Optional;

@Entity
@Getter
@Setter
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;
    private String description;

    private int priority;

    private Date endingDate;
    private Date creationDate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;



    private boolean status;

    public Task() {

    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


}
