package com.example.tp_hopital.entities;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_patient", nullable = false)
    private Long idPatient;

    private String lastName;
    private String firstName;
    private Date dateOfBirth;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] image;

@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Consultation> consultationList;

    public Patient() {
    }

    public Patient(String lastName, String firstName, Date dateOfBirth, byte[] image) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
        this.image = image;
    }

    public Long getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Long idPatient) {
        this.idPatient = idPatient;
    }
}
