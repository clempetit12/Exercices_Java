package com.example.weather_api.controller;


import com.example.weather_api.entity.WeatherForecast;
import com.example.weather_api.repository.WeatherRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Random;

@RequestMapping("weather")
@RestController
public class WeatherAPIController {

    private final Random random;

    private final WeatherRepository weatherRepository;

    public WeatherAPIController(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
        random = new Random();
    }

    @GetMapping("{city}")
    public Flux<WeatherForecast> get(@RequestParam("city") String city) {
        return weatherRepository.findWeatherForecastByCity(city);
    }

    @PostMapping
    public Mono<WeatherForecast> add(@RequestBody WeatherForecast weatherForecast) {
        String city = weatherForecast.getCity();
        double temperature = weatherForecast.getTemperature();
        WeatherForecast weatherForecast2 = WeatherForecast.builder().city(city).temperature(temperature).build();
        return weatherRepository.save(weatherForecast2);

    }
}
