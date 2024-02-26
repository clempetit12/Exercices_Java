package com.example.exercice_meteorologie.entity;

import jakarta.persistence.*;

import java.util.UUID;


@Entity
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String weather;

    private int temperature;



    public Weather(String weather, int temperature) {
        this.weather = weather;
        this.temperature = temperature;
    }

    public Weather() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}
