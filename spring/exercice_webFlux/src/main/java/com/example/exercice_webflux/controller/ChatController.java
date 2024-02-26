package com.example.exercice_webflux.controller;

import com.example.exercice_webflux.service.MessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.ArrayList;

@RestController
public class ChatController {
    private final MessageService messageService;
    private ArrayList<SseEmitter> membersChat = new ArrayList<>();

    public ChatController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public String home(){
        return "subscribe";
    }

    @GetMapping("subscribeToChat")
    public SseEmitter subscribeToChat() {
        SseEmitter emitter = new SseEmitter();
        messageService.addSubscriber(emitter);
        return emitter;
    }

    public void broadcastMessage(String message) {
        for (SseEmitter emitter : membersChat) {
            try {
                emitter.send(message);
            } catch (Exception e) {
            }
        }
    }
}
