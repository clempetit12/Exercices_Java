package org.example.service;

import org.example.entity.Expense;
import org.example.port.ExpenseRepository;

import java.util.List;

public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;

    }

    public Expense create(String title, double amount) {
        Expense expense = new Expense.Builder().title(title).amount(amount).build();
        expenseRepository.create(expense);
        return expense;

    }

    public List<Expense> findAll() {
        return expenseRepository.findAll();

    }

    public Expense findById(Long id) {
        return expenseRepository.findById(id);

    }
}
