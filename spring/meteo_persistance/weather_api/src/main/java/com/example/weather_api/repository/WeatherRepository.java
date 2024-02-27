package com.example.weather_api.repository;

import com.example.weather_api.entity.WeatherForecast;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface WeatherRepository extends R2dbcRepository<WeatherForecast,Long> {
    @Query("SELECT id, city, temperature FROM weatherForecast WHERE city=:city")
    Flux<WeatherForecast> findWeatherForecastByCity(String city);


}
