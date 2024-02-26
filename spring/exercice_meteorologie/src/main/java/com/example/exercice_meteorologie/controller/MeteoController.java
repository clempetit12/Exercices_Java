package com.example.exercice_meteorologie.controller;

import com.example.exercice_meteorologie.entity.News;
import com.example.exercice_meteorologie.entity.Weather;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("meteo")
public class MeteoController {

private WebClient webClient;

    public MeteoController() {
        webClient = WebClient.builder().baseUrl("http://localhost:8080").build();
    }


    @GetMapping
    public Flux<String> get() {
        return  this.webClient.get().uri("/news")
                .retrieve()
                .bodyToFlux(String.class).delayElements(Duration.ofSeconds(2));
    }

    @GetMapping
    @RequestMapping("/zip")
    public Flux<Object> getZip() {
        Flux<String> flux1 = this.webClient.get().uri("/news")
                .retrieve()
                .bodyToFlux(String.class).delayElements(Duration.ofSeconds(5));

        Flux<String> flux2 = this.webClient.get().uri("/weather")
                .retrieve()
                .bodyToFlux(String.class);

        return Flux.zip(flux1, flux2).map(t -> t.getT1()+t.getT2());
                };


}
