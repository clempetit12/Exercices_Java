package com.example.exercice_meteorologie.repository;

import com.example.exercice_meteorologie.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WeatherApi extends JpaRepository<Weather, Long> {
}
