package org.example.tp_blog.service;

import org.example.tp_blog.entity.Post;

import java.util.List;
import java.util.UUID;

public interface ServiceInterface<T> {

    public List<T> getAll();
    public T getById(int id);

    public T add(T element);

    public boolean delete(int id);

    public T update(T element);

}
