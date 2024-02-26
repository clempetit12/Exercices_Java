package com.example.exercice_webflux.service;

import com.example.exercice_webflux.entity.Message;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.time.LocalDateTime;

@Service
public class MessageService {

    private final Sinks.Many<Message> sink;

    public MessageService() {
        sink = Sinks.many().multicast().onBackpressureBuffer();
    }

    public void postMessage(Message message) {
        message.setTime(LocalDateTime.now());
        sink.tryEmitNext(message);
    }

    public Flux<Message> getFluxMessage() {
        return sink.asFlux();
    }


}
