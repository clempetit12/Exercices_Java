package com.example.tp_hopital.interfaces;

import java.util.List;

public interface Repository<T> {

    boolean create(T element);

    boolean update(T element);

    boolean delete(T element);

    T findById(Long id);

    List<T> findAll();
}
