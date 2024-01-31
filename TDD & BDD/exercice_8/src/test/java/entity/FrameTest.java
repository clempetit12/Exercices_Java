package entity;

import org.example.entity.BowlingGame;
import org.example.entity.Exception.*;
import org.example.entity.Frame;
import org.example.entity.PinGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FrameTest {

    private BowlingGame bowlingGame;
    private int currentIndexFrame;
    private Frame frame;
    @Mock
    private PinGenerator pinGenerator;

    @BeforeEach
    void setup() {
        bowlingGame = new BowlingGame(pinGenerator);
    }


    @Test
    void testFirstThrowHasToIncreaseScoreOfTheSerie() {
        frame = new Frame(pinGenerator, 1);
        Mockito.when(pinGenerator.getNumberOfPins()).thenReturn(5);
        frame.throwBall();
        int result = frame.getScore();
        Assertions.assertEquals(5, result);
    }

    @Test
    void testSecondThrowHasToIncreaseScoreOfTheSerie() {
        frame = new Frame(pinGenerator, 2);
        Mockito.when(pinGenerator.getNumberOfPins()).thenReturn(5);
        frame.throwBall();
        Mockito.when(pinGenerator.getNumberOfPins()).thenReturn(3);
        frame.throwBall();
        int result = frame.getScore();
        Assertions.assertEquals(8, result);
    }

    @Test
    void testNumberOfPinsCannotBeMoreThan10() {
        frame = new Frame(pinGenerator, 3);
        Mockito.when(pinGenerator.getNumberOfPins()).thenReturn(11);
        Assertions.assertThrowsExactly(NumberOfPinsException.class, () -> {
            frame.throwBall();
        });
    }

    @Test
    void testInCase10PinsFallenItsAStrike() {
        frame = new Frame(pinGenerator, 4);
        Mockito.when(pinGenerator.getNumberOfPins()).thenReturn(10);
        frame.throwBall();
        int result = frame.getScore();
        Assertions.assertEquals(20, result);

    }

    @Test
    void testInCase10PinsFallenItsAStrikeNoMoreLaunch() {
        frame = new Frame(pinGenerator, 4);
        Mockito.when(pinGenerator.getNumberOfPins()).thenReturn(10);
        frame.throwBall();
        Mockito.when(pinGenerator.getNumberOfPins()).thenReturn(10);
        Assertions.assertThrowsExactly(StrikeException.class, () -> {
            frame.throwBall();
        });


    }

    @Test
    void testInCase10PinsFallenItsAStrikeTrue() {
        frame = new Frame(pinGenerator, 8);
        Mockito.when(pinGenerator.getNumberOfPins()).thenReturn(10);
        frame.throwBall();
        Assertions.assertTrue(frame.isStrike());
    }

    @Test
    void testInCaseOfAStrikeImpossibleToLaunchASecondTime() {
        frame = new Frame(pinGenerator, 6);
        Mockito.when(pinGenerator.getNumberOfPins()).thenReturn(10);
        frame.throwBall();
        Assertions.assertThrowsExactly(StrikeException.class, () -> {
            frame.throwBall();
        });
    }

    @Test
    void testInFinalRoundWhenStrikeItsPossibleToRelaunch() {
        frame = new Frame(pinGenerator, 9);
        Mockito.when(pinGenerator.getNumberOfPins()).thenReturn(10);
        frame.throwBall();
        Mockito.when(pinGenerator.getNumberOfPins()).thenReturn(8);
        frame.throwBall();
        Mockito.when(pinGenerator.getNumberOfPins()).thenReturn(8);
        frame.throwBall();
        int result = frame.getScore();
        Assertions.assertEquals(26, result);
    }


    @Test
    void testInFinalRoundWhenSpareItIsPossibleToRelaunch() {
        frame = new Frame(pinGenerator, 9);
        Mockito.when(pinGenerator.getNumberOfPins()).thenReturn(5);
        frame.throwBall();
        Mockito.when(pinGenerator.getNumberOfPins()).thenReturn(5);
        frame.throwBall();
        Mockito.when(pinGenerator.getNumberOfPins()).thenReturn(6);
        frame.throwBall();
        int result = frame.getScore();
        Assertions.assertEquals(16, result);

    }

    @Test
    void testInFinalRoundWhenNoSpareOrNoStrikeMaximunNumberOfLaunch4() {
        frame = new Frame(pinGenerator, 9);
        Mockito.when(pinGenerator.getNumberOfPins()).thenReturn(5);
        frame.throwBall();
        Mockito.when(pinGenerator.getNumberOfPins()).thenReturn(5);
        frame.throwBall();
        Mockito.when(pinGenerator.getNumberOfPins()).thenReturn(6);
        frame.throwBall();
        Mockito.when(pinGenerator.getNumberOfPins()).thenReturn(6);
        frame.throwBall();
        Mockito.when(pinGenerator.getNumberOfPins()).thenReturn(6);
        Assertions.assertThrowsExactly(LaunchException.class, () -> {
            frame.throwBall();
        });

    }

    @Test
    void testGetScoreWithStrikes() {
            Mockito.when(pinGenerator.getNumberOfPins()).thenReturn(10);
            bowlingGame.roll();
            Mockito.when(pinGenerator.getNumberOfPins()).thenReturn(10);
            bowlingGame.roll();
            Mockito.when(pinGenerator.getNumberOfPins()).thenReturn(10);
            bowlingGame.roll();
            Mockito.when(pinGenerator.getNumberOfPins()).thenReturn(10);
            bowlingGame.roll();
            Mockito.when(pinGenerator.getNumberOfPins()).thenReturn(10);
            bowlingGame.roll();
            Mockito.when(pinGenerator.getNumberOfPins()).thenReturn(10);
            bowlingGame.roll();
            Mockito.when(pinGenerator.getNumberOfPins()).thenReturn(10);
            bowlingGame.roll();
            Mockito.when(pinGenerator.getNumberOfPins()).thenReturn(10);
            bowlingGame.roll();
            Mockito.when(pinGenerator.getNumberOfPins()).thenReturn(10);
            bowlingGame.roll();
        Mockito.when(pinGenerator.getNumberOfPins()).thenReturn(10);
        bowlingGame.roll();
        Mockito.when(pinGenerator.getNumberOfPins()).thenReturn(10);
        bowlingGame.roll();

        int result = bowlingGame.getScore();
        Assertions.assertEquals(300, result);
    }


}
