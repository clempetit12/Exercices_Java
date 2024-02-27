package com.example.composition_news_weather.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class NewsWeatherDTO {
    private String city;
    private double temperature;

    private List<NewsDTO> news;
}
