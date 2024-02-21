package org.example.boutique_bonbons.repository;

import org.example.boutique_bonbons.entity.Candy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "candy", collectionResourceRel = "candies")
public interface CandyRepository extends CrudRepository<Candy,Long> {
}
