package com.example.composition_news_weather.service;

import com.example.composition_news_weather.dto.WeatherDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class WeatherService {
    private final WebClient webClient;

    public WeatherService() {
        webClient = WebClient.builder().baseUrl("http://localhost:8080/").build();
    }

    public Mono<WeatherDTO> get(String city) {
        return webClient.get().uri("weather/"+city).retrieve().bodyToMono(WeatherDTO.class);
    }
}
