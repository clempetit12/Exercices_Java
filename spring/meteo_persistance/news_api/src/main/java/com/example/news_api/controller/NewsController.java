package com.example.news_api.controller;


import com.example.news_api.entity.News;
import com.example.news_api.repository.NewsRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("news")
public class NewsController {

    private final NewsRepository newsRepository;

    public NewsController(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @GetMapping("{city}")
    public Mono<List<News>> get(@PathVariable("city") String city) {
        return Mono.just(Arrays.asList(News.builder().city(city).content(city +" News 1").build(), News.builder().city(city).content(city +" News 2").build()));
    }


    @PostMapping
    public Mono<News> addNews(@RequestBody News news){
        String city = news.getCity();
        String content = news.getContent();
        LocalDateTime date = news.getDateTime();
        News news2 = News.builder().city(city).content(content).dateTime(date).build();
        return newsRepository.save(news2);
    }
}
