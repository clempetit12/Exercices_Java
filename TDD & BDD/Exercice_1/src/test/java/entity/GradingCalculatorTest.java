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
    @Test
    void testGradeF() {
        GradingCalculator gradingCalculator = new GradingCalculator();
        gradingCalculator.setScore(50);
        gradingCalculator.setAttendancePercentage(90);
        char result = gradingCalculator.getGrade();
        Assertions.assertEquals('F', result);
    }
}
