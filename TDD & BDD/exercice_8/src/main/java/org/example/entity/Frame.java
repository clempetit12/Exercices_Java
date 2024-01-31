package org.example.entity;

import lombok.Data;
import org.example.entity.Exception.LaunchException;
import org.example.entity.Exception.NumberOfPinsException;
import org.example.entity.Exception.StrikeException;


@Data
public class Frame {

    private static final int MAX_PINS = 10;
    private PinGenerator pinGenerator;
    private int pinsDownFirstThrow;
    private int score;
    int numberOfThrow;
    int round;
    private boolean isStrike = false;
    private boolean isSpare = false;
    private int currentIndexFrame;

    public Frame(PinGenerator pinGenerator, int currentFrameIndex) {
        this.pinGenerator = pinGenerator;
        this.numberOfThrow = 1;
        this.score = 0;
        this.round = 1;
        this.currentIndexFrame = currentFrameIndex;
    }

    public void throwBall() {
        int pinsDown = pinGenerator.getNumberOfPins();

        if (currentIndexFrame < 9) {
            if (pinsDown > MAX_PINS) {
                throw new NumberOfPinsException();
            } else if (isStrike) {
                throw new StrikeException();
            } else if (pinsDown == MAX_PINS) {
                isStrike = true;
                score += 10;
                currentIndexFrame++;
                setNumberOfThrow(1);
            } else {
                score += pinsDown;
            }


        } else if (currentIndexFrame == 9) {

            if (isStrike) {

            } else {

                score += pinsDown;


                if (numberOfThrow == 2 && pinsDown == MAX_PINS) {
                    score += 10;
                } else {
                    int pinsDownSecondThrow = pinGenerator.getNumberOfPins();
                    score += pinsDownSecondThrow;
                }
            }
        } else if (currentIndexFrame == 10) {
            if (numberOfThrow >4) {
                throw  new LaunchException();
            }
            if (pinsDown == MAX_PINS) {
                setStrike(true);
            }
            if (isStrike) {
                score += 2 * pinsDown;
                isStrike = false;
                numberOfThrow++;
            } else if (score == 5 && pinsDown == 5) {

                score += pinsDown;
                int pinsDownSecondThrow = pinGenerator.getNumberOfPins();
                if (pinsDown + pinsDownSecondThrow == MAX_PINS) {
                    score = pinsDown + pinsDownSecondThrow + 10;
                    numberOfThrow++;
                } else {
                    score += pinsDownSecondThrow;
                    numberOfThrow++;
                }
            } else {
                score += pinsDown;
                numberOfThrow++;
            }
        }


    }


    public boolean isRoundComplete() {
        return isStrike || numberOfThrow == 2;
    }
}
