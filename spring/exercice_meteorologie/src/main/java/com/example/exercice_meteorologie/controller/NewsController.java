package com.example.exercice_meteorologie.controller;

import com.example.exercice_meteorologie.entity.News;
import com.example.exercice_meteorologie.service.NewsService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("news")
public class NewsController {

private final NewsService newsService;


    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }
    @PostMapping("add")
    public ResponseEntity<String> addNews(@RequestBody News news) {
        newsService.save(news);
        this.newsService.sendNews(news);
        return ResponseEntity.ok("Ok");
    }


    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<News> get() {
        return newsService.getFlux();
    }

}
