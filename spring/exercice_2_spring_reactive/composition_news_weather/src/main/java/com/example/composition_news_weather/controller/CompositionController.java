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
    public Flux<NewsWeatherDTO> get(@PathVariable("cities")List<String> cities) {
        Flux<WeatherDTO> weatherDtoFlux = weatherService.getCities(cities);
        Flux<NewsDTO> newsWeatherDTOFlux = newsService.getNews(cities);

        return Flux.zip(weatherDtoFlux, newsWeatherDTOFlux)
                .map(t -> NewsWeatherDTO.builder()
                        .temperature(t.getT1().getTemperature())
                        .cities(Arrays.asList(t.getT1()))
                        .news(Arrays.asList(t.getT2()))
                        .build());
    }
}
