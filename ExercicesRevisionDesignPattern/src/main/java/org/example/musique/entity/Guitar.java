package org.example.musique.entity;

public class Guitar implements Instruments{
    private String type;
    public Guitar(String type) {
        this.type = type;
    }

    @Override
    public String getInstrument() {
        return "Guitar (" + type + ")";
    }

}
