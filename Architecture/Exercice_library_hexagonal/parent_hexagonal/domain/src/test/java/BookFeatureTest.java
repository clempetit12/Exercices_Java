import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.example.entity.Book;
import org.example.service.BookService;
import org.example.spi.port.BookRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class BookFeatureTest {

    private BookService bookService;
    private Book book;

    private List<Book> resultSearch;

    private final BookRepository bookRepository;
    public BookFeatureTest() {

        bookRepository = Mockito.mock(BookRepository.class);
        bookService = new BookService(bookRepository);
        book = new Book.Builder().title("toto").author("tata").build();
    }
    @Given("there are some books in the library")
    public void there_are_some_books_in_the_library() {
        Mockito.doAnswer(invocationOnMock -> {
            Book b = invocationOnMock.getArgument(0);
            b.setIdBook(1L);
            return null;
        }).when(bookRepository).create(book);

        bookService.create("toto", "tata");
    }
    @When("I search for books with title started with {string}")
    public void i_ask_for_all_books(String search) {
        Mockito.when(bookRepository.searchBook(search)).thenReturn(List.of(book));
        resultSearch = bookService.searchBook(search);
    }
    @Then("List with {int} book should be returned")
    public void all_books_should_be_returned(int size) {

        Assertions.assertEquals(size, resultSearch.size());
    }


}
