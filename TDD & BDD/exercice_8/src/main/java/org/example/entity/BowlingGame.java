package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    private static final int MAX_FRAMES = 10;
    private List<Frame> frames;
    private int currentFrameIndex;
    private PinGenerator pinGenerator;

    public BowlingGame(PinGenerator pinGenerator) {
        frames = new ArrayList<>();
        for (int i = 0; i < MAX_FRAMES; i++) {
            frames.add(new Frame(pinGenerator,i));
        }
        currentFrameIndex = 0;
    }

    public Frame getCurrentFrame() {
        return frames.get(currentFrameIndex);
    }

    public void roll() {
        Frame currentFrame = getCurrentFrame();
        currentFrame.throwBall();


        if (currentFrame.isRoundComplete()) {
            currentFrameIndex++;
        }
    }

    public int getScore() {
        int totalScore = 0;
        for (Frame frame : frames) {
            totalScore += frame.getScore();
        }
        return totalScore;
    }

    public List<Frame> getFrames() {
        return frames;
    }

    public void setFrames(List<Frame> frames) {
        this.frames = frames;
    }

    public int getCurrentFrameIndex() {
        return currentFrameIndex;
    }

    public void setCurrentFrameIndex(int currentFrameIndex) {
        this.currentFrameIndex = currentFrameIndex;
    }

    public PinGenerator getPinGenerator() {
        return pinGenerator;
    }

    public void setPinGenerator(PinGenerator pinGenerator) {
        this.pinGenerator = pinGenerator;
    }
}
