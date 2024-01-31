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
            if (currentFrameIndex < 9) {
                currentFrameIndex++;
            }

        }
    }

    public int getScore() {
        int totalScore = 0;
        for (int i = 0; i < frames.size(); i++) {
            Frame frame = frames.get(i);
            totalScore += frame.getScore();
            if (frame.isStrike() && i < frames.size() - 1) {
                Frame nextFrame = frames.get(i + 1);
                totalScore += nextFrame.getScore();
                if (nextFrame.isStrike() && i < frames.size() - 2) {
                    totalScore += frames.get(i + 2).getScore();
                }
            }
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
