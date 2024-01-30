package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class HangedMan {

    private RandomWords randomWords;
    private String currentWord;
    private List<Character> charactersFound;

    public HangedMan(RandomWords randomWords) {
        this.randomWords = randomWords;
        this.currentWord = play();
        this.charactersFound  = new ArrayList<>();
    }

    public RandomWords getRandomWords() {
        return randomWords;
    }

    public void setRandomWords(RandomWords randomWords) {
        this.randomWords = randomWords;
    }

    public String getCurrentWord() {
        return currentWord;
    }

    public void setCurrentWord(String currentWord) {
        this.currentWord = currentWord;
    }

    public String play() {
        return randomWords.getWord();

    }

    public boolean charInWord(char lettre, String wordToBeFound) {
        if (wordToBeFound.contains(String.valueOf(lettre))) {
            charactersFound.add(lettre);
            System.out.println("Bravo vous avez trouvé une lettre");
            return true;

        }
        System.out.println("Essayez encore, ce n'est pas la bonne lettre");
        return false;
    }

    public boolean hasWon() {
        for (char c : currentWord.toCharArray()) {
            if (!charactersFound.contains(c)) {
                System.out.println("Vous n'avez pas encore gagné");
                return false;
            }
        }
        System.out.println("Bravo vous avez gagnée ! ");
        return true;
    }

    public List<Character> getGuessedLetters() {
        return charactersFound;
    }
}
