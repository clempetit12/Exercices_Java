package com.example.tp_hopital.entity;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPatient;

    private String lastName;

    private String firstName;
    private Date dateOfBirth;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] image;
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Consultation> consultationList;

    public Patient(String lastName, String firstName, Date dateOfBirth, byte[] image) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
        this.image = image;
    }
}
