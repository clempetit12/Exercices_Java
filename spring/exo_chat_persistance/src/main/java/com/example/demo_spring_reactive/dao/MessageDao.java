package com.example.demo_spring_reactive.dao;

import com.example.demo_spring_reactive.model.Message;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Component
public class MessageDao {

private final ConnectionFactory connectionFactory;

private final DatabaseClient databaseClient;

    public MessageDao(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
        databaseClient = DatabaseClient.create(connectionFactory);
        Mono result = databaseClient.sql("CREATE TABLE IF NOT EXISTS message(id BIGINT  primary key auto_increment, sender varchar(100), content varchar(100), message_Date_Time DATETIME )")
                .then().doOnSuccess((Void) -> {
                    System.out.println("Création de la table OK");
                }).doOnError((Void) -> {
                    System.out.println("Création de la table KO");
                });
        result.subscribe();
    }


    public Mono add(Message message) {
        Map<String, Object> values = new HashMap<>();
        values.put("sender", message.getSender());
        values.put("content", message.getContent());
        values.put("messageDateTime", message.getMessageDateTime());
        Mono result = databaseClient.sql("INSERT INTO message (sender, content, message_Date_Time) values (:firstname, :lastname, :messageDateTime)")
                .bindValues(values)
                .then();
        return result;
    }

public Flux<Message> getAll() {
        return databaseClient.sql("SELECT id, sender, content, message_Date_Time from message").fetch()
                .all()
                .map(m -> Message.builder()
                        .id(Long.valueOf(m.get("id").toString()))
                        .content(m.get("content").toString())
                        .sender(m.get("sender").toString())
                        .messageDateTime(((java.sql.Timestamp) m.get("messageDateTime")).toLocalDateTime())
                        .build());
}


public Mono<Void> delete(Long id) {
return databaseClient.sql("DELETE FROM message WHERE id=:id").bind("id",id).then();
}
}
