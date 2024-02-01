package com.example.tp_hopital.repository;

import com.example.tp_hopital.entity.CareFile;

import java.util.List;

public class CareFileRepository extends Repository<CareFile> {
    @Override
   public CareFile findById(Long id) {
        return session.get(CareFile.class,id);
    }

    @Override
   public List<CareFile> findAll() {
   return session.createQuery("from CareFile ").list();
    }
}
