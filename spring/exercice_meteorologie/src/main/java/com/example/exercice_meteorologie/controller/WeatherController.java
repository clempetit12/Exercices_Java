package com.example.exercice_meteorologie.controller;


import com.example.exercice_meteorologie.entity.News;
import com.example.exercice_meteorologie.entity.Weather;
import com.example.exercice_meteorologie.service.WeatherService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("weather")
public class WeatherController {

    private final WeatherService weatherService;


    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @PostMapping("add")
    public ResponseEntity<String> addNews(@RequestBody Weather weather) {
        weatherService.save(weather);
        this.weatherService.sendWeather(weather);
        return ResponseEntity.ok("Ok");
    }


    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Weather> get() {
        return weatherService.getFlux();
    }
}
