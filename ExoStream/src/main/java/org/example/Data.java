package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Data {

    private String text;

    public Data(String text) {
        setText(text);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = deletePunctuation(text).toLowerCase();
    }

    public static String deletePunctuation(String text) {
        String textWithoutPunctuation = text.replaceAll("[^\\w\\s]", "");
        return textWithoutPunctuation;
    }

    public  Map<String, Long> frequencyOfWord(){
        Stream<String> words = Arrays.stream(text.split("\\s+"));
        Map<String, Long> wordFrequencyMap = words.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return wordFrequencyMap;

    }

    public  List<String> lengthWord(int wordLength) {
        Stream<String> words = Arrays.stream(text.split("\\s+"));
        Stream<String> wordLenghyFiltered = words.filter(w -> w.length() > wordLength);
        List<String> resultList = wordLenghyFiltered.collect(Collectors.toList());

        return resultList;
    }

    public Set<String> singleWords() {
        Stream<String> words = Arrays.stream(text.split("\\s+"));
        return words.collect(HashSet::new, HashSet::add, HashSet::addAll);
    }

    public  void  mostUsedWords() {

        Stream<String> words = Arrays.stream(text.split("\\s+"));
        Map<String, Long> wordFrequencyMap = frequencyOfWord();
        String mostFrequentWord = null;
        long highestFrequency = 0;


        for (Map.Entry<String, Long> entry : wordFrequencyMap.entrySet()) {
            String word = entry.getKey();
            long frequency = entry.getValue();

            if (frequency > highestFrequency) {
                highestFrequency = frequency;
                mostFrequentWord = word;
            }
        }
        System.out.println("Most frequent word: " + mostFrequentWord + ", Frequency: " + highestFrequency);

    }

    public  void statisticsLengthOfWords () {
        Stream<String> words = Arrays.stream(text.split("\\s+"));
       DoubleSummaryStatistics statisticLengthOfWord = words.collect(
                Collectors.summarizingDouble(String::length)
        );
        System.out.println("Longueur moyenne des mots: " + statisticLengthOfWord.getAverage());
        System.out.println("Longueur minimale des mots: " + statisticLengthOfWord.getMin());
        System.out.println("Longueur maximale des mots: " + statisticLengthOfWord.getMax());
    }


    @Override
    public String toString() {
        return "Data{" +
                "text='" + text + '\'' +
                '}';
    }
}
