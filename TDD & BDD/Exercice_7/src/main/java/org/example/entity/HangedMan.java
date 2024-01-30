package org.example.entity;

public class HangedMan {

    private RandomWords randomWords;
    private String currentWord;

    public HangedMan(RandomWords randomWords) {
        this.randomWords = randomWords;
        this.currentWord = play();
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

    public boolean charInWord(char lettre) {
        if (play().contains(String.valueOf(lettre))) {
            System.out.println("Bravo vous avez trouvé une lettre");
            return true;
        }
        System.out.println("Essayez encore, ce n'est pas la bonne lettre");
        return false;
    }

    public boolean hasWon() {
        for (char c : currentWord.toCharArray()) {
            if (!charInWord(c)) {
                System.out.println("Vous n'avez pas encore gagné");
                return false;
            }
        }
        System.out.println("Bravo vous avez gagnée ! ");
        return true;
    }
}
