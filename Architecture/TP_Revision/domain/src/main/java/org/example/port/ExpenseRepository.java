package org.example.port;

import org.example.entity.Expense;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ExpenseRepository {

    boolean create(Expense expense);

    List<Expense> findAll();

    Expense findById(Long id);


}
