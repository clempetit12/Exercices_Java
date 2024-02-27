package com.example.demo_spring_reactive.controller;


import com.example.demo_spring_reactive.dto.MessageDTO;
import com.example.demo_spring_reactive.model.Message;
import com.example.demo_spring_reactive.service.MessageService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("messages")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Message> get() {
        return messageService.getFlux();
    }

    @PostMapping
    public Mono<Message> post(@RequestBody MessageDTO messageDTO) {
        return messageService.sendMessage(messageDTO.getSender(), messageDTO.getContent());
    }

    @GetMapping("/search/{search}")
    public Flux<Message> getMessageContaining(@PathVariable("search") String search) {
        return messageService.getMessageContaining(search);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteMessage(@PathVariable("id") Long id){
        return messageService.deleteMessage(id);
    }

}
