package com.example.exercice_student.service;

import java.util.List;
import java.util.UUID;

public interface Service<T> {

    public List<T> getAll();
    public T getById(UUID id);

    public boolean add(T element);

    public List<T> getByName(String name);


}
