package org.example.entity;

import org.example.builder.CastleBuilder;

public class Castle extends Building {

    private int size;
    private String style;
    private String name;

    public Castle(CastleBuilder builder) {
        size = builder.getSize();
        style = builder.getStyle();
        name = builder.getName();
    }
}