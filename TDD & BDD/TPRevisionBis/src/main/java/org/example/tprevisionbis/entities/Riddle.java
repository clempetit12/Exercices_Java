package org.example.tprevisionbis.entities;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "riddle")
public class Riddle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "riddle_text")
    private String riddleText;
    @Column(name = "expected_answer")
    private String expectedAnswer;
    private String userAnswer;

    public Riddle(String riddleText, String expectedAnswer) {
        this.riddleText = riddleText;
        this.expectedAnswer = expectedAnswer;
    }

    public Riddle(Long id, String riddleText, String expectedAnswer) {
        this.id = id;
        this.riddleText = riddleText;
        this.expectedAnswer = expectedAnswer;
    }

    public Riddle() {
    }
}
