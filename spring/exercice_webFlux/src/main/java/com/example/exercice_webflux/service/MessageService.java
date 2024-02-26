package com.example.exercice_webflux.service;

import com.example.exercice_webflux.entity.Message;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class MessageService {

    private final Sinks.Many<Message> sink;
    private ArrayList<SseEmitter> membersChat = new ArrayList<>();


    public MessageService() {
        sink = Sinks.many().multicast().onBackpressureBuffer();
    }

    public void postMessage(Message message) {
        message.setId(UUID.randomUUID());
        message.setTime(LocalDateTime.now());
        sink.tryEmitNext(message);
    }

    public Flux<Message> getFluxMessage() {
            return sink.asFlux();

    }


    public void addSubscriber(SseEmitter emitter) {
        membersChat.add(emitter);

    }
}
