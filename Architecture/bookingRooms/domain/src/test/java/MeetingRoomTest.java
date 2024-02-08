import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.entity.MeetingRoom;
import org.example.entity.Reservation;
import org.example.entity.User;
import org.example.entity.UsersEnum;
import org.example.port.MeetingRoomRepository;
import org.example.port.ReservationRepository;
import org.example.port.UserRepository;
import org.example.service.MeetingRoomService;
import org.example.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class MeetingRoomTest {

    @Mock
    private MeetingRoomRepository meetingRoomRepository;

    @Mock
    private ReservationRepository reservationRepository;

    private MeetingRoom room1;
    private MeetingRoom room2;
    private User user;
    @InjectMocks
    private MeetingRoomService meetingRoomService;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private List<MeetingRoom> availableRooms;
    private UsersEnum usersEnum;

    private Reservation reservation;

    public MeetingRoomTest() {
        meetingRoomRepository = Mockito.mock(MeetingRoomRepository.class);
        meetingRoomService = new MeetingRoomService(meetingRoomRepository);
        room1 = new MeetingRoom.Builder().id(1L).capacity(10).build();
        room2 = new MeetingRoom.Builder().id(2L).capacity(50).build();
        user = new User.Builder().firstName("helene").lastName("patard").userEnum(usersEnum).build();
        usersEnum = UsersEnum.ADMINISTRATOR;
        reservation = new Reservation.Builder().date(LocalDate.of(2024, 2, 8))
                .userId(user.getId())
                .meetingRoomId(room1.getId())
                .beginningHour(LocalTime.of(9, 0))
                .finishingHour(LocalTime.of(10, 0)).build();




    }


    @Given("there are some meeting rooms")
    public void thereAreSomeMeetingRooms() {
        Mockito.when(meetingRoomRepository.searchAvailableMeetingRoom(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.anyInt(), Mockito.anyBoolean()))
                .thenReturn(Collections.singletonList(room1));
    }

    @When("I search available meeting rooms for the given date and time")
    public void iSearchAvailableMeetingRoomsForTheGivenDateAndTime() {
        LocalDate date = LocalDate.now();
        LocalTime startTime = LocalTime.of(9, 0);
        LocalTime endTime = LocalTime.of(10, 0);
        availableRooms = meetingRoomService.searchAvailableRooms(date, startTime, endTime, 50, true);
    }

    @Then("one meeting room is returned")
    public void oneMeetingRoomIsReturned() {
        Assertions.assertEquals(1,availableRooms.size());
    }
}
