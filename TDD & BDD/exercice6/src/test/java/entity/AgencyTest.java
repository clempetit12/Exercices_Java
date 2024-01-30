package entity;

import org.example.entity.Agency;
import org.example.entity.Car;
import org.example.exception.ConditionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AgencyTest {

    private Agency agency;
    private Car car;

    @BeforeEach
    void setUp() {
        agency = new Agency();

    }


    @Test
    void testDailyRoutineExpirationRentDueInConditionValueDecreaseTwiceTimesMore() {
        int rentDueIn = -1;
        int condition = 90;
        car = Car.builder().rentDueIn(rentDueIn).condition(condition).build();
        agency.dailyRoutine(car);
        Assertions.assertEquals(88, car.getCondition());

    }

    @Test
    void testDailyRoutineConditionCarisNeverNegative() {
        int condition = -10;
        int rentDueIn = 5;
        car = Car.builder().rentDueIn(rentDueIn).condition(condition).build();

        Assertions.assertThrowsExactly(ConditionException.class, () -> {
            agency.dailyRoutine(car);
        });

    }

    @Test
    void testDailyRoutineConditionCarisNeverOver100() {
        int condition = 200;
        int rentDueIn = 5;
        car = Car.builder().rentDueIn(rentDueIn).condition(condition).build();

        Assertions.assertThrowsExactly(ConditionException.class, () -> {
            agency.dailyRoutine(car);
        });

    }

    @Test
    void testDailyRoutineConditionLuxuryCarIncreaseWithTime() {
        int condition = 50;
        int rentDueIn = 5;
        String category = "luxury";
        car = Car.builder().rentDueIn(rentDueIn).condition(condition).category(category).build();
        agency.dailyRoutine(car);

    }


}
