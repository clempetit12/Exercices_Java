package com.example.composition_news_weather.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WeatherDTO {
    private String city;
    private double temperature;
}
