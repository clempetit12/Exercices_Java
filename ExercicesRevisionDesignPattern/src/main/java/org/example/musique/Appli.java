package org.example.musique;

import org.example.zoo.Zoo;
import org.example.zoo.entity.Animal;

import java.util.ArrayList;
import java.util.List;

public class Appli {

    private static volatile Appli instance = null;
    private static final Object lock = new Object();
    private Sound sound;
    private Composition composition;
    private List<Composition> compositionList;

    public List<Composition> getCompositionList() {
        return compositionList;
    }

    public Sound getSound() {
        return sound;
    }


    private Appli() {
        compositionList = new ArrayList<>();
        sound = Sound.MEDIUM;
    }

    public static Appli getInstance() {
        if (instance == null) {
            synchronized (lock) {
                instance = new Appli();
            }
        }
        return instance;
    }

    public  void displayCompositionList() {
        for (Composition c : compositionList) {
            System.out.println(c);
        }
    }
        public  void addComposition(Composition composition) {
            compositionList.add(composition);
    }

    public void setSound(Sound sound) {
        this.sound = sound;
    }

    @Override
    public String toString() {
        return "Appli{" +
                "sound=" + sound +
                ", compositionList=" + compositionList +
                '}';
    }
}





