package com.example.weather_api.dao;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class WeatherDao {
    private final ConnectionFactory connectionFactory;

    private final DatabaseClient databaseClient;


    public WeatherDao(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
        databaseClient = DatabaseClient.create(connectionFactory);
        Mono result = databaseClient.sql("CREATE TABLE IF NOT EXISTS weather_forecast(id BIGINT  primary key auto_increment, city varchar(100), temperature double )")
                .then().doOnSuccess((Void) -> {
                    System.out.println("Création de la table OK");
                }).doOnError((Void) -> {
                    System.out.println("Création de la table KO");
                });
        result.subscribe();
    }



}
