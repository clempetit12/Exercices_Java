package com.example.adapter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MeetingRoomDto {

    private Long id;
    private boolean availibility;
    private int capacity;
}
