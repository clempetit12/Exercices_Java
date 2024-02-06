package org.example.repository;

import org.example.entity.BookEntity;

import java.util.List;

public class BookEntityRepository extends BaseEntityRepository<BookEntity> {
    @Override
    BookEntity findById(Long id) {
        return session.get(BookEntity.class,id);
    }

    @Override
    List<BookEntity> fildAll() {
        return session.createQuery("from BookEntity", BookEntity.class).list();
    }

    List<BookEntity> findAllByKey(String key) {
        return (session.createQuery("from BookEntity where title like :q")
                .setParameter("q",key)
                .list());
    }
}
