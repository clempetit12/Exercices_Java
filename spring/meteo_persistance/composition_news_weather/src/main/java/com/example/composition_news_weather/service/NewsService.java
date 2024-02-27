package com.example.composition_news_weather.service;

import com.example.composition_news_weather.dto.NewsDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class NewsService {

    private final WebClient webClient;

    public NewsService() {
        this.webClient = WebClient.builder().baseUrl("http://localhost:8081").build();
    }

    public Mono<NewsDTO[]> get(String city) {
        return webClient.get().uri("news/"+city).retrieve().bodyToMono(NewsDTO[].class);
    }
}
