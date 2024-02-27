package com.example.demo_spring_reactive.service;

import com.example.demo_spring_reactive.dao.MessageDao;
import com.example.demo_spring_reactive.model.Message;
import com.example.demo_spring_reactive.repository.MessageRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class MessageService {

    private final MessageRepository messageRepository;
    private final MessageDao messageDao;

    public MessageService(MessageRepository messageRepository, MessageDao messageDao) {
        this.messageRepository = messageRepository;
        this.messageDao = messageDao;
    }

    public Mono<Message> sendMessage(String sender, String content) {
        Message message = Message.builder().sender(sender).content(content).messageDateTime(LocalDateTime.now()).build();
        return messageRepository.save(message);
    }


    public Flux<Message> getFlux() {
       return messageRepository.findAll();

    }

    public Flux<Message> getMessageContaining(String search) {
        return messageRepository.findMessageBySenderContainingIgnoreCase(search);
    }

    public Mono<Void> deleteMessage(Long id){
        return messageDao.delete(id);
    }


}
