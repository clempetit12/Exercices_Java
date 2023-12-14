package org.example.musique.entity;

public class Violin implements Instruments{
    private String type;
    public Violin(String type) {
        this.type = type;
    }

    @Override
    public String getInstrument() {
        return "Violin (" + type + ")";
    }

}
