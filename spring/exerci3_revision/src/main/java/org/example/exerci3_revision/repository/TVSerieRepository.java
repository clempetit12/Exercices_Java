package org.example.exerci3_revision.repository;


import org.example.exerci3_revision.entity.TVSerie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TVSerieRepository extends CrudRepository<TVSerie,Long> {
}
