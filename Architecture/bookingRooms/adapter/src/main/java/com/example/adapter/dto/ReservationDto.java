package com.example.adapter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Date;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto {

    private Long id;
    private Long meetingRoomId;

    private Long userId;

    private Date date;

    private LocalTime beginningHour;

    private LocalTime finishingHour;
}
