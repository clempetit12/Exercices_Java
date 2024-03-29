package org.example.todospring.service;

import java.util.List;
import java.util.Optional;

public interface Service<T> {

    public T save(T element);

    public boolean delete(T element);

    public T update(T element);

    public T getById(Long id);

    public List<T> getAll();
}
