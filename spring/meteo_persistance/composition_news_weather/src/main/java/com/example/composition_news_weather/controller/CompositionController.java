package com.example.composition_news_weather.controller;

import com.example.composition_news_weather.dto.NewsDTO;
import com.example.composition_news_weather.dto.NewsWeatherDTO;
import com.example.composition_news_weather.dto.WeatherDTO;
import com.example.composition_news_weather.service.NewsService;
import com.example.composition_news_weather.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;

@RestController
@RequestMapping("/")
public class CompositionController {
    private final WeatherService weatherService;
    private final NewsService newsService;

    public CompositionController(WeatherService weatherService, NewsService newsService) {
        this.weatherService = weatherService;
        this.newsService = newsService;
    }

    @GetMapping("{city}")
    public Mono<NewsWeatherDTO> get(@PathVariable("city") String city) {
        Mono<WeatherDTO> weatherDTOMono = weatherService.get(city);
        Mono<NewsDTO[]> newsWeatherDTOMono = newsService.get(city);

        return Mono.zip(weatherDTOMono, newsWeatherDTOMono)
                .map(t -> NewsWeatherDTO.builder()
                        .temperature(t.getT1().getTemperature())
                        .city(city)
                        .news(Arrays.asList(t.getT2()))
                        .build());
    }
}
