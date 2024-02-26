package com.example.news_api.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class News {
    private String city;
    private String content;
    private LocalDateTime dateTime;
}
