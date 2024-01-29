package entity;

import org.example.entity.GradingCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GradingCalculatorTest {

    @Test
    void testGradeA() {
        GradingCalculator gradingCalculator = new GradingCalculator();
        gradingCalculator.setScore(95);
        gradingCalculator.setAttendancePercentage(90);
        char result = gradingCalculator.getGrade();
        Assertions.assertEquals('A', result);
    }

    //- Score : 85%, Présence : 90 => Note: B
    // Score : 95%, Présence : 65 => Note: B
    @Test
    void testGradeB() {
        GradingCalculator gradingCalculator = new GradingCalculator();
        gradingCalculator.setScore(95);
        gradingCalculator.setAttendancePercentage(65);
        char result = gradingCalculator.getGrade();
        Assertions.assertEquals('B', result);
    }

    @Test
    void testGradeC() {
        GradingCalculator gradingCalculator = new GradingCalculator();
        gradingCalculator.setScore(65);
        gradingCalculator.setAttendancePercentage(90);
        char result = gradingCalculator.getGrade();
        Assertions.assertEquals('C', result);
    }

    // - Score : 95%, Présence : 55 => Note: F
    // - Score : 65%, Présence : 55 => Note: F
    // - Score : 50%, Présence : 90 => Note: F
    @Test
    void testGradeF() {
        GradingCalculator gradingCalculator = new GradingCalculator();
        gradingCalculator.setScore(50);
        gradingCalculator.setAttendancePercentage(90);
        char result = gradingCalculator.getGrade();
        Assertions.assertEquals('F', result);
    }
}
