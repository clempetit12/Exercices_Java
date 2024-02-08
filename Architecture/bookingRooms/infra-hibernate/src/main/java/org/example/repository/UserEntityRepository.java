package org.example.repository;

import org.example.entity.User;

import java.util.List;

public class UserEntityRepository extends BaseEntityRepository<User> {
    @Override
    User findById(Long id) {
        return session.get(User.class,id);
    }

    @Override
    List<User> findAll() {
        return session.createQuery("from UserEntity ", User.class).list();
    }
}
