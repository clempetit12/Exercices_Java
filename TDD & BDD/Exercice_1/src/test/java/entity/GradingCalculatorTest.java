package entity;

import org.example.entity.GradingCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GradingCalculatorTest {

    private GradingCalculator gradingCalculator;

    private void initGradingCalculator(int score, int attendance) {
        gradingCalculator = new GradingCalculator();
        gradingCalculator.setScore(score);
        gradingCalculator.setAttendancePercentage(attendance);
    }
    @Test
    void testGradeA() {
        initGradingCalculator(95,90);
        char result = gradingCalculator.getGrade();
        Assertions.assertEquals('A', result);
    }

    //- Score : 85%, Présence : 90 => Note: B
    // Score : 95%, Présence : 65 => Note: B
    @Test
    void testGradeB() {
        initGradingCalculator(95,65);
        char result = gradingCalculator.getGrade();
        Assertions.assertEquals('B', result);
    }

    @Test
    void testGradeC() {
        initGradingCalculator(65,90);
        char result = gradingCalculator.getGrade();
        Assertions.assertEquals('C', result);
    }

    // - Score : 95%, Présence : 55 => Note: F
    // - Score : 65%, Présence : 55 => Note: F
    // - Score : 50%, Présence : 90 => Note: F
    @Test
    void testGradeF() {
        initGradingCalculator(50,90);
        char result = gradingCalculator.getGrade();
        Assertions.assertEquals('F', result);
    }
}
