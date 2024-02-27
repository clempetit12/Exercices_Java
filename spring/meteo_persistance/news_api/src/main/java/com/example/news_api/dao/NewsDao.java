package com.example.news_api.dao;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class NewsDao {


    private final DatabaseClient databaseClient;

    private  final ConnectionFactory connectionFactory;


    public NewsDao(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
        databaseClient = DatabaseClient.create(connectionFactory);
        Mono result = databaseClient.sql("CREATE TABLE IF NOT EXISTS news(id BIGINT  primary key auto_increment, city varchar(100), content varchar(100), date_Time DATETIME  )")
                .then().doOnSuccess((Void) -> {
                    System.out.println("Création de la table OK");
                }).doOnError((Void) -> {
                    System.out.println("Création de la table KO");
                });
        result.subscribe();
    }



}
