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
            if(isRoundComplete()) {
                currentIndexFrame++;
                numberOfThrow = 1;
            }
            if (pinsDown > MAX_PINS) {
                throw new NumberOfPinsException();
            } else if (isStrike) {
                throw new StrikeException();
            } else if (pinsDown == MAX_PINS) {
                isStrike = true;
                pinsDownFirstThrow = 10;
                score +=10;
                currentIndexFrame++;

            }else {
                score += pinsDown;
                pinsDownFirstThrow = pinsDown;
                numberOfThrow++;
            }
        } else if (currentIndexFrame == 9) {
            if (numberOfThrow >4) {
                throw  new LaunchException();
            }
            if (pinsDown == MAX_PINS) {
                setStrike(true);
            }
            if (isStrike) {
                score += 10;
                numberOfThrow++;
                if (numberOfThrow > 2) {
                    isStrike = false;
                }
            } else if (score == 5 && pinsDown == 5) {
                pinsDownFirstThrow = pinsDown;
                score += pinsDown;
                int pinsDownSecondThrow = pinGenerator.getNumberOfPins();
                if (pinsDown + pinsDownSecondThrow == MAX_PINS) {
                    score = pinsDown + pinsDownSecondThrow ;
                    numberOfThrow++;
                } else {
                    score += pinsDownSecondThrow;
                    numberOfThrow++;
                }
            } else {
                pinsDownFirstThrow = pinsDown;
                score += pinsDown;
                numberOfThrow++;
            }
        }


    }

    public boolean isRoundComplete() {
        return isStrike || numberOfThrow >2;
    }

    public int getFirstThrow() {
        return pinsDownFirstThrow;
    }
}
