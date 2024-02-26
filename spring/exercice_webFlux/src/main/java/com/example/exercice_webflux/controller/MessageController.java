package com.example.exercice_webflux.controller;

import com.example.exercice_webflux.entity.Message;
import com.example.exercice_webflux.service.MessageService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "messages")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("postMessage")
    public ResponseEntity<String> postMessage(@RequestBody Message message) {
        this.messageService.postMessage(message);
        return ResponseEntity.ok("OK");
    }



    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Message> get() {
        return messageService.getFluxMessage();
    }
}
