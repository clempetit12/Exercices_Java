package entities;

import org.example.tprevisionbis.entities.Riddle;
import org.example.tprevisionbis.repository.Repository;
import org.example.tprevisionbis.repository.RiddleRepository;
import org.example.tprevisionbis.service.RiddleService;
import org.example.tprevisionbis.util.HibernateSession;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class RiddleTest {

    private Riddle riddle;
    private RiddleService riddleService;
    Repository<Riddle> riddleRepository;

    SessionFactory sessionFactory;

    @BeforeEach
    void setUp() {
        riddleRepository = Mockito.mock(RiddleRepository.class);
        riddleService = new RiddleService(riddleRepository, HibernateSession.getSessionFactory());
        riddle = new Riddle();
    }
    @Test
    void testSubmissionNewRiddleToDatabase() {
        String riddleText = "Je parle sans bouche et entends sans oreilles. Je n'ai ni corps, ni âme, mais je peux faire pleurer tout le monde. Qu'est-ce que je suis ?";
        String answerExpected = "telephone";
        Riddle riddle1 = new Riddle(riddleText,answerExpected);
        Boolean result = riddleService.create(riddle1);
        Assertions.assertTrue(result);


    }

    @Test
    void testSubmissionAnswerIsTrue() {
        String userAnswer = "telephone";
        Riddle riddle1 = riddleService.findRiddle(1L);
        Boolean isCorrectAnswer = riddleService.checkUserAnswer(userAnswer,1L);
        Assertions.assertTrue(isCorrectAnswer);


    }


    @Test
    void testGetAllRiddleFromDatabase() {
        Riddle riddle = new Riddle(1L, "Question?", "Answer");
        Riddle riddle2 = new Riddle(2L, "Question2?", "Answer2");
        Riddle riddle3 = new Riddle(3L, "Question3?", "Answer3");

        List<Riddle> database = Arrays.asList(riddle, riddle2, riddle3);
        RiddleService mockRiddleService = Mockito.mock(RiddleService.class);
        Mockito.when(mockRiddleService.getAllRiddle()).thenReturn(database);
        List<Riddle> actualRiddles = mockRiddleService.getAllRiddle();
        Assertions.assertEquals(database.size(), actualRiddles.size());
        Assertions.assertTrue(actualRiddles.containsAll(database));
    }


}
