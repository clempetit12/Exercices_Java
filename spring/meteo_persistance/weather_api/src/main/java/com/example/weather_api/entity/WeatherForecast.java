package com.example.weather_api.entity;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Builder
public class WeatherForecast {
    @Id
    private Long id;
    private String city;
    private double temperature;
}
