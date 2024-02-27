package com.example.demo_spring_reactive.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.http.MediaType;

import java.awt.*;
import java.time.Duration;

@RestController
@RequestMapping("reactives")
public class DemoReactiveController {

    //Une méthode qui renvoie un mono (objet asychrone de reactor)
    @GetMapping
    public Mono<String> get() {
        return Mono.just("Hello from get method");
    }


    //Une méthode qui renvoie un flux de données (object flux de reactor) à un client qui accepte le stream, avec un delay de 2 secondes entre chaque réponse
    @GetMapping(value = "flux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> getFlux() {
        return Flux.just("toto", "tata", "titi").delayElements(Duration.ofSeconds(2));
    }

}
