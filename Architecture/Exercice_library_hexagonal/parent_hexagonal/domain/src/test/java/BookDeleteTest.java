import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.entity.Book;
import org.example.service.BookService;
import org.example.spi.port.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class BookDeleteTest {

    private BookService bookService;
    private Book book;

    private List<Book> resultSearch;

    private final BookRepository bookRepository;
    public BookDeleteTest() {

        bookRepository = Mockito.mock(BookRepository.class);
        bookService = new BookService(bookRepository);
        book = new Book.Builder().title("toto").author("tata").build();
        resultSearch = new ArrayList<>();
    }

    @Given("there are  books in the library")
    public void there_is_books_in_the_library() {
        Mockito.doAnswer(invocationOnMock -> {
            Book b = invocationOnMock.getArgument(0);
            b.setIdBook(1L);
            return null;
        }).when(bookRepository).create(book);
        resultSearch.add( bookService.create("toto", "tata"));
    }
    @When("I delete a book with id 1L")
    public void i_delete_a_book_with_id_1l() {
        Mockito.when(bookRepository.delete(1L)).thenReturn(true);
        bookService.delete(1L);
        resultSearch = bookService.getAllBooks();



    }
    @Then("List with {int} books should be returned")
    public void list_with_books_should_be_returned(int size) {
        Assertions.assertEquals(size, resultSearch.size());
    }
}
