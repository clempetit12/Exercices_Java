package com.example.weather_api.entity;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WeatherForecast {
    private String city;
    private double temperature;
}
