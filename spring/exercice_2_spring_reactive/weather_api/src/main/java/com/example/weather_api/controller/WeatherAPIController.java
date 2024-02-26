package com.example.weather_api.controller;


import com.example.weather_api.entity.WeatherForecast;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Random;

@RequestMapping("weather")
@RestController
public class WeatherAPIController {

    private final Random random;

    public WeatherAPIController() {
        random = new Random();
    }

    @GetMapping("{city}")
    public Mono<WeatherForecast> get(@PathVariable("city") String city) {
        return Mono.just(WeatherForecast.builder().city(city).temperature(random.nextDouble()).build());
    }
}
