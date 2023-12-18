package org.example;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
      String newText = "I'm still standing, yeah, yeah, yeah ! It's the final countdown tutu, tututu, tutu, tututu. Thunderstruck Thunderstruck !";

      Data data = new Data(newText);
        Map<String, Long> frequencyOfWord = data.frequencyOfWord();
        System.out.println(frequencyOfWord);
        List<String> lengthWord = data.lengthWord(4);
        System.out.println(lengthWord);
data.singleWords();
      data.mostUsedWords();
      data.statisticsLengthOfWords();

    }
}