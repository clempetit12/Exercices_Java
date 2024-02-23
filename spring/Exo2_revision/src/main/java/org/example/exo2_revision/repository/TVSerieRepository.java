package org.example.exo2_revision.repository;

import jdk.dynalink.linker.LinkerServices;
import org.example.exo2_revision.entity.TVSerie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(path = "tvserie", collectionResourceRel = "tvseries")
public interface TVSerieRepository extends CrudRepository<TVSerie, Long> {


    //GET http://localhost:8080/tvserie/search/searchgendra?gendra={genre}
    @RestResource(path = "searchgendra")
    List<TVSerie> findAllByGendra(String gendra);

    //GET http://localhost:8080/tvserie/search/searchstatus?status={status}
    @RestResource(path = "searchstatus")
    List<TVSerie> findAllByStatus(boolean status);


    // PUT http://localhost:8080/tvserie/2

}
