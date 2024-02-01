package com.example.tp_hopital.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class CareFile {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_care_file", nullable = false)
    private Long idCareFile;

    private String care;
    private String duration;


    @ManyToOne
    @JoinColumn(name = "consultation_id")
    private Consultation consultation;

    public CareFile() {
    }

}
