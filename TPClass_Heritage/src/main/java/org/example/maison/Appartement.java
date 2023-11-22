package org.example.maison;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Appartement extends Maison  {

    public Appartement( Porte porte) {
        super(50, porte);
    }

    private static List<Porte> getDefaultPortes() {
        return Collections.emptyList();
    }
    @Override
    public String toString() {
        return "Je suis un appartement, ma surface est de " +
                surface + "m²";
    }
}
