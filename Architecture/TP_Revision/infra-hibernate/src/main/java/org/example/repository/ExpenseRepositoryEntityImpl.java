package org.example.repository;

import org.example.entity.Expense;
import org.example.entity.ExpenseEntity;
import org.example.port.ExpenseRepository;
import org.example.utils.HibernateSession;
import org.hibernate.Session;

import java.util.List;
import java.util.stream.Collectors;

public class ExpenseRepositoryEntityImpl implements ExpenseRepository {

    private ExpenseRepositoryEntity expenseRepositoryEntity;

    public ExpenseRepositoryEntityImpl() {
        expenseRepositoryEntity = new ExpenseRepositoryEntity();
    }
    @Override
    public boolean create(Expense expense) {
        Session session = HibernateSession.getSessionFactory().openSession();
        expenseRepositoryEntity.setSession(session);
        session.beginTransaction();
        try {
            ExpenseEntity expenseEntity = ExpenseEntity.builder().
                    title(expense.getTitle())
                    .amount(expense.getAmount()).build();
            session.getTransaction().commit();
            expense.setId(expenseEntity.getId());
            return true;

        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public List<Expense> findAll() {
        Session session = HibernateSession.getSessionFactory().openSession();
        expenseRepositoryEntity.setSession(session);
        session.beginTransaction();
        try {
            List<ExpenseEntity> expenseEntities = expenseRepositoryEntity.findAll();
            List<Expense> expenseList = expenseEntities.stream().map(expenseEntity -> expenseEntity.toExpense())
                    .collect(Collectors.toList());

            return expenseList;
        } catch (
                Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public Expense findById(Long id) {
        Session session = HibernateSession.getSessionFactory().openSession();
        expenseRepositoryEntity.setSession(session);
        session.beginTransaction();
        try {
            ExpenseEntity expenseEntity = expenseRepositoryEntity.findById(id);
            Expense expense = expenseEntity.toExpense();
            session.getTransaction().commit();
            expense.setId(expenseEntity.getId());
            return expense;

        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
    }
}
