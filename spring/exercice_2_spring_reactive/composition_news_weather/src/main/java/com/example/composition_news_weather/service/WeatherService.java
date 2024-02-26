package com.example.composition_news_weather.service;

import com.example.composition_news_weather.dto.NewsDTO;
import com.example.composition_news_weather.dto.NewsWeatherDTO;
import com.example.composition_news_weather.dto.WeatherDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Service
public class WeatherService {
    private final WebClient webClient;

    public WeatherService() {
        webClient = WebClient.builder().baseUrl("http://localhost:8080/").build();
    }

    public Flux<WeatherDTO> getCities(String cities) {
        return webClient.get().uri("weather/"+cities).retrieve().bodyToFlux(WeatherDTO.class);
    }




}
