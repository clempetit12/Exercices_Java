package org.example;

import org.example.entity.HangedMan;
import org.example.entity.RandomWords;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        RandomWords randomWords = new RandomWords();
        String[] words = {"bateau", "tableau", "fleur", "ballet"};
        randomWords.setRandomWords(words);
        randomWords.getWord();
        HangedMan hangedMan = new HangedMan(randomWords);
        String wordToBefound = hangedMan.play();
        System.out.println(wordToBefound);
        StringBuilder maskedWord = new StringBuilder("_".repeat(wordToBefound.length()));
        do {
            System.out.println("Veuillez préciser une lettre");
            char lettre = scanner.next().charAt(0);
            Set<Character> guessedLetters = new HashSet<>();

            if (hangedMan.charInWord(lettre, wordToBefound)) {
                for (int i = 0; i < wordToBefound.length(); i++) {
                    if (wordToBefound.charAt(i) == lettre) {
                        maskedWord.setCharAt(i, lettre);
                    }

                }
                guessedLetters.add(lettre);
                System.out.println("Mot actuel: " + maskedWord.toString());
            } else {

            }

        } while (!hangedMan.hasWon());


    }
}