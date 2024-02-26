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
public class NewsService {

    private final WebClient webClient;

    public NewsService() {
        this.webClient = WebClient.builder().baseUrl("http://localhost:8081").build();
    }

    public Flux<NewsDTO> getNews(String cities) {
        return webClient.get().uri("news/"+cities).retrieve().bodyToFlux(NewsDTO.class);
    }


}
