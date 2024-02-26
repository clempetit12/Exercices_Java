package com.example.news_api.controller;


import com.example.news_api.entity.News;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("news")
public class NewsController {

    @GetMapping("{city}")
    public Mono<List<News>> get(@PathVariable("city") String city) {
        return Mono.just(Arrays.asList(News.builder().city(city).content(city +" News 1").build(), News.builder().city(city).content(city +" News 2").build()));
    }
}
