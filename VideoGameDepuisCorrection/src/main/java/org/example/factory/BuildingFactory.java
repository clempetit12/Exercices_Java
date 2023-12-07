package org.example.factory;

import org.example.builder.BuildingBuilder;
import org.example.entity.Building;

public abstract class BuildingFactory {
    abstract Building createBuilding(BuildingBuilder builder);
}
