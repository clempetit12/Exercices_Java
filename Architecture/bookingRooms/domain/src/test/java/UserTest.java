import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.entity.User;
import org.example.entity.UsersEnum;
import org.example.port.UserRepository;
import org.example.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserTest {

    private User user1;
    private User user2;

    private UserService userService;

    private final UserRepository userRepository;

    public UserTest() {
        userRepository = Mockito.mock(UserRepository.class);
        userService = new UserService(userRepository);

    }



    @Given("there are two users")
    public void thereAreTwoUsersOneWithIdL() {
        UsersEnum role1 = UsersEnum.USER;
        UsersEnum role2 = UsersEnum.ADMINISTRATOR;
        user1 = new User.Builder().firstName("toto").lastName("tata").userEnum(role1).build();
        Mockito.doAnswer(invocationOnMock -> {
            User u = invocationOnMock.getArgument(0);
            u.setId(1L);
            return null;
        }).when(userRepository).create(user1);
        user2 = new User.Builder().firstName("helene").lastName("patard").userEnum(role2).build();
        Mockito.doAnswer(invocationOnMock -> {
            User u = invocationOnMock.getArgument(0);
            u.setId(2L);
            return null;
        }).when(userRepository).create(user2);
        userService.create("helene", "patard", role2);
        userService.create("toto", "tata", role1);

    }
    @When("I search for user administrator with usersEnum equals to {string} and id equals to {int}")
    public void iSearchForUserAdministratorWithUsersEnumEqualsToAndIdEqualsTo(String arg0, int id) {
        int idInt = id;
        long idLong = idInt;
        Mockito.when(userRepository.findById(idLong)).thenReturn(user2);
        String expectedResult = "ADMINISTRATOR";
        String actualResult = user2.getUsersEnum().name();
        Assertions.assertEquals(expectedResult,actualResult);
    }





    @Then("One user returned with id {int}")
    public void oneUserReturnedWithId(int id) {
        int idInt = id;
        long idLong = idInt;
        Mockito.when(userRepository.findById(idLong)).thenReturn(user2);
        Assertions.assertEquals(2,user2.getId());
    }
}
