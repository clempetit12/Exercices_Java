package org.example.exo1_revision.service;

import java.util.List;
import java.util.UUID;

public interface RecepyInterface <T>{

    public List<T> getAll();
    public T getById(UUID id);

    public boolean add(T element,String[] ingredientsArray );

    public List<T> searchByTitle(String title);


}
