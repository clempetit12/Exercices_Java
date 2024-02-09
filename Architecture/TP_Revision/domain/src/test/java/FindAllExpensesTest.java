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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindAllExpensesTest {

    @Mock
    private ExpenseRepository expenseRepository;

    private Expense expense;

    private List<Expense> expenseList ;

    @InjectMocks
    private ExpenseService expenseService;

    public FindAllExpensesTest() {
        expenseRepository = Mockito.mock(ExpenseRepository.class);
        expenseService = new ExpenseService(expenseRepository);
        expense = new Expense.Builder().title("course").amount(300).build();

    }


    @Given("there are expenses")
    public void thereAreExpenses() {
        expense = new Expense.Builder().title("course").amount(300).build();
        Mockito.doAnswer(invocationOnMock -> {
            Expense e = invocationOnMock.getArgument(0);
            e.setId(1L);
            return null;
        }).when(expenseRepository).create(expense);
        expenseService.create("course", 300);
    }



    @When("I search for all expenses")
    public void iSearchForAllExpenses() {
        Mockito.when(expenseRepository.findAll()).thenReturn(List.of(expense));
        expenseList = expenseService.findAll();
    }

    @Then("List with {int} expense should be returned")
    public void listWithExpenseShouldBeReturned(int size) {
        Assertions.assertEquals(size,expenseList.size());
    }
}
