package com.example.exercice_meteorologie.service;

import com.example.exercice_meteorologie.entity.News;
import com.example.exercice_meteorologie.repository.NewsApi;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Service
public class NewsService {


    private final Sinks.Many<News> sink;

    private final NewsApi newsApi;

    public NewsService(NewsApi newsApi) {
        this.newsApi = newsApi;
        sink = Sinks.many().multicast().onBackpressureBuffer();
    }

    public News save(News news) {
        newsApi.save(news);
        return news;
    }

    public void sendNews(News news) {
        sink.tryEmitNext(news);
    }

    public Flux<News> getFlux() {
        return sink.asFlux();
    }
}
