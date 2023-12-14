package org.example.musique.entity;

public class Drum implements Instruments{

    private String type;
    public Drum(String type) {
        this.type = type;
    }

    @Override
    public String getInstrument() {
        return "Drum (" + type + ")";
    }


}
