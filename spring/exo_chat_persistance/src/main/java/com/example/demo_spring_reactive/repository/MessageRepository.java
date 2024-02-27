package com.example.demo_spring_reactive.repository;

import com.example.demo_spring_reactive.model.Message;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MessageRepository extends R2dbcRepository<Message,Long> {

    @Query("SELECT id, sender, content, message_Date_Time FROM message WHERE sender LIKE CONCAT(:sender, '%')")
    Flux<Message> findMessageBySenderContainingIgnoreCase(String sender);


}
