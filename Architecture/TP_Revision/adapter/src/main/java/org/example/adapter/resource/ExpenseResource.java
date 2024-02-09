package org.example.adapter.resource;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.entity.Expense;
import org.example.repository.ExpenseRepositoryEntityImpl;
import org.example.service.ExpenseService;

import java.util.List;

@Path("expenses")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ExpenseResource {

    private final ExpenseService expenseService;


    public ExpenseResource() {
        expenseService = new ExpenseService(new ExpenseRepositoryEntityImpl());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Expense> getAll() {
        List<Expense> expenseList = expenseService.findAll();
        return expenseList;
    }


    @POST
    public Expense post(Expense expense) {
        return expenseService.create(expense.getTitle(), expense.getAmount());
    }

}
