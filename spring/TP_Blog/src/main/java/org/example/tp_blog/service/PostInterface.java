package org.example.tp_blog.service;

import java.util.List;
import java.util.UUID;

public interface PostInterface <T> {

    public List<T> getAll();
    public T getById(UUID id);

    public boolean add(T element);

    public boolean deletePost(T element);

    public T update(UUID id,T element);





}
