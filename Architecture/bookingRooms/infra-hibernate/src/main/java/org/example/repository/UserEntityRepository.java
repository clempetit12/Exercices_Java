package org.example.repository;

import org.example.entity.User;
import org.example.entity.UserEntity;

import java.util.List;

public class UserEntityRepository extends BaseEntityRepository<UserEntity> {
    @Override
    UserEntity findById(Long id) {
        return session.get(UserEntity.class,id);
    }

    @Override
    List<UserEntity> findAll() {
        return session.createQuery("from UserEntity ", UserEntity.class).list();
    }
}
