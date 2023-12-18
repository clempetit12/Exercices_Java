package org.example.factory;

import org.example.builder.BuildingBuilder;
import org.example.entity.Building;

public class Forgefactory extends BuildingFactory {

    @Override
    Building createBuilding(BuildingBuilder builder) {
        return builder.build();
    }
}
