import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.entity.Expense;
import org.example.port.ExpenseRepository;
import org.example.service.ExpenseService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ExpenseTest {

    @Mock
    private ExpenseRepository expenseRepository;

    private Expense expense;

    private Expense resultSearch;

    @InjectMocks
    private ExpenseService expenseService;

    public ExpenseTest() {
        expenseRepository = Mockito.mock(ExpenseRepository.class);
        expenseService = new ExpenseService(expenseRepository);
        expense = new Expense.Builder().amount(200).title("transport").build();

    }


    @Given("I add an expense")
    public void iAddAnExpense() {
        expense = new Expense.Builder().title("transport").amount(200).build();
        Mockito.doAnswer(invocationOnMock -> {
            Expense e = invocationOnMock.getArgument(0);
            e.setId(1L);
            return null;
        }).when(expenseRepository).create(expense);
        expenseService.create("transport", 200);
    }

    @When("I search for expense with id equals to {int}")
    public void iSearchAnExpenseMithId(int id) {
        Mockito.when(expenseService.findById((long)id)).thenReturn(expense);
        resultSearch= expenseService.findById((long)id);

    }

    @Then("{int} expense should be returned")
    public void one_expense_shoulb_be_returned_with_id(Integer id) {
        Expense returnedExpense = expenseService.findById(1L);
        Assertions.assertNotNull(returnedExpense, "Expense should not be null");
    }


}
