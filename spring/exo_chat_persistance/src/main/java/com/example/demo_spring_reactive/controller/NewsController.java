package com.example.demo_spring_reactive.controller;


import com.example.demo_spring_reactive.service.NewsService;
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

    @GetMapping("add/{news}")
    public ResponseEntity<String> addNews(@PathVariable("news") String news) {
        this.newsService.sendNews(news);
        return ResponseEntity.ok("Ok");
    }


    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> get() {
        return newsService.getFlux();
    }
}
