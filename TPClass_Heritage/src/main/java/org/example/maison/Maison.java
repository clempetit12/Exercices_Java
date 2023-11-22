package org.example.maison;

import java.util.List;

public class Maison {
    int surface;
private Porte porte;

    public Maison(int surface,Porte porte) {
        this.surface = surface;
        this.porte = porte;
    }

    public int getSurface() {
        return surface;
    }

    public void setSurface(int surface) {
        this.surface = surface;
    }

    public void display() {
        System.out.println("Je suis une maison, ma surface est de "+ getSurface() + "m²") ;
    }

    public Porte getPorte() {
        return porte;
    }

    @Override
    public String toString() {
        return "Maison{" +
                "surface=" + surface +
                ", portes=" + porte +
                '}';
    }
}
