package com.example.demo_spring_reactive.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
@RequestMapping("clientnews")
public class ClientNewsController {

    private WebClient webClient;

    public ClientNewsController() {
        webClient = WebClient.builder().baseUrl("http://localhost:8080").build();
    }
    @GetMapping
    public Flux<String> get() {
        //appelle une autre application reactive
        return  this.webClient.get().uri("/news")
                .retrieve()
                .bodyToFlux(String.class).delayElements(Duration.ofSeconds(2));
    }

    @GetMapping
    @RequestMapping("zip")
    public Flux<Object> getZip() {
        Flux<String> flux1 = this.webClient.get().uri("/news")
                .retrieve()
                .bodyToFlux(String.class).delayElements(Duration.ofSeconds(2));

        Flux<String> flux2 = this.webClient.get().uri("/reactives/flux")
                .retrieve()
                .bodyToFlux(String.class);
        return Flux.zip(flux1, flux2).map(t -> t.getT1()+t.getT2());
    }

}
