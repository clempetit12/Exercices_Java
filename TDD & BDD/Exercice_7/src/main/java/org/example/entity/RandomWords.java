package org.example.entity;

import java.util.Random;

public class RandomWords implements RWord {

    private Random random;
    private String[] randomWords ;

    public RandomWords(Random random) {
        this.random = random;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public String[] getRandomWords() {
        return randomWords;
    }

    public void setRandomWords(String[] randomWords) {
        this.randomWords = randomWords;
    }

    @Override
    public String getWord() {
        int randomIndex = random.nextInt(randomWords.length);
        return randomWords[randomIndex];
    }
}
