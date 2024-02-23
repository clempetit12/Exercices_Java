package org.example.exerci3_revision.repository;

import org.example.exerci3_revision.entity.Season;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonRepository extends CrudRepository<Season,Long> {
}
