package com.example.exercice_meteorologie.service;

import com.example.exercice_meteorologie.entity.Weather;
import com.example.exercice_meteorologie.repository.WeatherApi;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Service
public class WeatherService {


    private final Sinks.Many<Weather> sink;
    private WeatherApi weatherApi;



    public WeatherService(WeatherApi weatherApi) {
        this.weatherApi = weatherApi;
        sink = Sinks.many().multicast().onBackpressureBuffer();
    }

    public Weather save(Weather weather) {
        weatherApi.save(weather);
        return weather;
    }

    public void sendWeather(Weather weather) {
        sink.tryEmitNext(weather);
    }

public Flux<Weather> getFlux() {
        return sink.asFlux();
}
}
