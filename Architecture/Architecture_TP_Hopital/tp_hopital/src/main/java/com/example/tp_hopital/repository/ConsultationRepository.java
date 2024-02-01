package com.example.tp_hopital.repository;

import com.example.tp_hopital.entity.Consultation;

import java.util.List;

public class ConsultationRepository extends Repository<Consultation> {

    public ConsultationRepository() {
    }

    @Override
    public Consultation findById(Long id) {
        return session.get(Consultation.class,id);

    }

    @Override
    public List<Consultation> findAll() {
       return session.createQuery("from Consultation ").list();
    }
}
