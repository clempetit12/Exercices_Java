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
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindAllExpensesTest {

    @Mock
    private ExpenseRepository expenseRepository;

    private Expense expense;
    private Expense expense2;

    private List<Expense> expenseList= new ArrayList<>();

    @InjectMocks
    private ExpenseService expenseService;

    public FindAllExpensesTest() {
        expenseRepository = Mockito.mock(ExpenseRepository.class);
        expenseService = new ExpenseService(expenseRepository);


    }

    @Given("there are two expenses, one with id {int}")
    public void thereAreTwoExpensesOneWithId(int id) {
        expense = new Expense.Builder().title("transport").amount(200).build();
        Mockito.doAnswer(invocationOnMock -> {
            Expense e = invocationOnMock.getArgument(0);
            e.setId((long) id);
            return null;
        }).when(expenseRepository).create(expense);
        expenseService.create("transport", 200);
        expenseList.add(expense);

    }

    @And("second with id {int}")
    public void secondWithId(int id) {
        expense2 = new Expense.Builder().title("course").amount(200).build();
        Mockito.doAnswer(invocationOnMock -> {
            Expense e = invocationOnMock.getArgument(0);
            e.setId((long) id);
            return null;
        }).when(expenseRepository).create(expense);
        expenseService.create("course", 200);
        expenseList.add(expense2);
    }

    @When("the user requests to view the list of expenses")
    public void the_user_requests_to_view_the_list_of_expenses() {
        Mockito.when(expenseService.findAll()).thenReturn(expenseList);
    }
    @Then("the user should see a summary of all expenses")
    public void the_user_should_see_a_summary_of_all_expenses() {
        Assertions.assertEquals(2, expenseList.size());

    }

}
