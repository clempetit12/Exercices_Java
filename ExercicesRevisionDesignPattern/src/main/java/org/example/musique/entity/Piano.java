package org.example.musique.entity;

public class Piano implements Instruments{
    private String type;
    public Piano(String type) {
        this.type = type;
    }

    @Override
    public String getInstrument() {
        return "Piano (" + type + ")";
    }

}
