package com.example.composition_news_weather.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewsDTO {
    private String city;
    private String content;
}
