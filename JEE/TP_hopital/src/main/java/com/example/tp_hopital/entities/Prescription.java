package com.example.tp_hopital.entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_prescription", nullable = false)
    private Long idPrescription;
    private String medication;
    private int duration;


    @ManyToOne
    @JoinColumn(name = "consultation_id")
    private Consultation consultation;


}
