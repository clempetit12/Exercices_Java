package org.example.repository;

import org.example.entity.Expense;
import org.example.entity.ExpenseEntity;

import java.util.List;

public class ExpenseRepositoryEntity extends BaseEntityRepository<ExpenseEntity> {
    @Override
    List<ExpenseEntity> findAll() {
        return session.createQuery("from ExpenseEntity ", ExpenseEntity.class).list();
    }

    @Override
    ExpenseEntity findById(Long id) {
        return session.get(ExpenseEntity.class,id);
    }
}
