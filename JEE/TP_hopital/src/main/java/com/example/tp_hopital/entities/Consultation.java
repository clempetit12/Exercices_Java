package com.example.tp_hopital.entities;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_consultation", nullable = false)
    private Long idConsultation;

    private Date consultationDate;
    private String doctorName;

    @OneToMany(mappedBy = "consultation", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Prescription> prescription;

    @OneToMany(mappedBy = "consultation", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<CareFile> careFile;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public Consultation() {
    }

    public Long getIdConsultation() {
        return idConsultation;
    }

    public void setIdConsultation(Long idConsultation) {
        this.idConsultation = idConsultation;
    }
}
