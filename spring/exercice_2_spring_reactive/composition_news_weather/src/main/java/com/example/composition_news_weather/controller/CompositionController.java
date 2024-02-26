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
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/")
public class CompositionController {
    private final WeatherService weatherService;
    private final NewsService newsService;

    public CompositionController(WeatherService weatherService, NewsService newsService) {
        this.weatherService = weatherService;
        this.newsService = newsService;
    }



    @GetMapping("/{cities}")
    public Flux<NewsWeatherDTO> get(@PathVariable("cities") List<String> cities) {
        return Flux.fromIterable(cities)
                .flatMap(city -> {
                    Flux<WeatherDTO> weatherMono = weatherService.getCities(city);
                    Flux<NewsDTO> news = newsService.getNews(city);

                    return Flux.zip(weatherMono, news)
                            .map(tuple -> NewsWeatherDTO.builder()
                                    .temperature(tuple.getT1().getTemperature())
                                    .cities(Collections.singletonList(tuple.getT1()))
                                    .news((List<NewsDTO>) tuple.getT2())
                                    .build());
                });
    }

}
