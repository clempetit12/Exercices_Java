package org.example.tprevisionbis.repository;

import org.example.tprevisionbis.entities.Riddle;
import org.hibernate.Session;

import java.util.List;

public class RiddleRepository extends Repository<Riddle> {
    public RiddleRepository() {

    }

    @Override
    public Riddle findById(Long id) {
        return session.get(Riddle.class,id);
    }

    @Override
    public List<Riddle> findAll() {
       return session.createQuery("FROM org.example.tprevisionbis.entities.Riddle",Riddle.class).list();
    }


}
