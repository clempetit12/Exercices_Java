package org.example.musique;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.musique.entity.*;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder

public class Composition {

    public String nameComposition;
    public List<Instruments> guitars;
    public List<Instruments> pianos;
    public List<Instruments> drums;
    public List<Instruments> violins;

    @Override
    public String toString() {
        return "Composition{" +
                "nameComposition='" + nameComposition + '\'' +
                ", guitars=" + instrumentsToString(guitars) +
                ", pianos=" + instrumentsToString(pianos) +
                ", drums=" + instrumentsToString(drums) +
                ", violins=" + instrumentsToString(violins) +
                '}';
    }

    private String instrumentsToString(List<Instruments> instruments) {
        if (instruments == null || instruments.isEmpty()) {
            return "null";
        } else {
            return instruments.stream()
                    .map(i -> i.getInstrument())
                    .collect(Collectors.joining(", ", "[", "]"));
        }
    }


    }



