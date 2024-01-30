package org.example;

import org.example.entity.HangedMan;
import org.example.entity.RandomWords;

import java.util.Random;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        RandomWords randomWords = new RandomWords();
        String[] words = {"bateau", "tableau", "fleur"};
        randomWords.setRandomWords(words);
        randomWords.getWord();
        HangedMan hangedMan = new HangedMan(randomWords);
        String wordToBefound = hangedMan.play();
        System.out.println(wordToBefound);
        do {
            System.out.println("Veuillez préciser une lettre");
            char lettre = scanner.next().charAt(0);
            if(hangedMan.charInWord(lettre,wordToBefound)) {
                System.out.println("bravo vous avez trouvé la lettre" + lettre);
            } else {
                System.out.println("essayez encore");
            }

        } while (!hangedMan.hasWon());


    }
}