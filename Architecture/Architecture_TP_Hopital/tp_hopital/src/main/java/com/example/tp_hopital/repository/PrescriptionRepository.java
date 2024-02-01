package com.example.tp_hopital.repository;

import com.example.tp_hopital.entity.Consultation;
import com.example.tp_hopital.entity.Prescription;

import java.util.List;

public class PrescriptionRepository  extends Repository<Prescription> {
    @Override
   public Prescription findById(Long id) {
        return session.get(Prescription.class,id);
    }

    @Override
    public  List<Prescription> findAll() {
        return session.createQuery("from Prescription ").list();
    }
}
