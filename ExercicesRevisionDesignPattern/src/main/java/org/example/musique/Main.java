package org.example.musique;

import org.example.musique.entity.*;

import java.util.Arrays;

public class Main {
    public static Appli appli = Appli.getInstance();
    public static void main(String[] args) {
        ProxyInstruments guitar = new ProxyInstruments(new Guitar("accoustique"));
        ProxyInstruments guitarElectrique = new ProxyInstruments(new Guitar("electrique"));
        ProxyInstruments drum = new ProxyInstruments(new Drum("classique"));
        ProxyInstruments violin = new ProxyInstruments(new Violin("electrique"));
        ProxyInstruments piano = new ProxyInstruments(new Piano("classique"));

        Composition composition1 = Composition.builder()
                .nameComposition("flute enchantee")
                .violins(Arrays.asList(violin))
                .drums(Arrays.asList(drum))
                .pianos(Arrays.asList(piano))
                .build();

appli.addComposition(composition1);
        System.out.println(appli.getSound());

        Composition composition2 = Composition.builder()
                .nameComposition("laziza")
                .guitars(Arrays.asList(guitar,guitarElectrique))
                .violins(Arrays.asList(violin))
                .drums(Arrays.asList(drum))
                .pianos(Arrays.asList(piano))
                .build();

        appli.addComposition(composition2);
        appli.setSound(Sound.HIGH);
        appli.displayCompositionList();
        System.out.println(appli.getSound());





    }
}
