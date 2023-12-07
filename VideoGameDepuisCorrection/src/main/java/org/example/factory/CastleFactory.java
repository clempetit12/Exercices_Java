package org.example.factory;

import org.example.builder.BuildingBuilder;
import org.example.entity.Building;

public class CastleFactory extends BuildingFactory {
    @Override
    public Building createBuilding(BuildingBuilder builder) {

        return builder.build();
    }
}
