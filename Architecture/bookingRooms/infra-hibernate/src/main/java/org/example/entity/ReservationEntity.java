package org.example.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Date;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "reservation")
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_reservation", nullable = false)
    private Long idReservation;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meeting_room_id", referencedColumnName = "id")
    private MeetingRoomEntity meetingRoom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

    private Date date;

    private LocalTime beginningHour;

    private LocalTime finishingHour;

    public Reservation toReservation() {
        return new Reservation.Builder().meetingRoomId(meetingRoom.getIdMeetingRoom())
                .userId(user.getIdUser())
                .date(date)
                .beginningHour(beginningHour)
                .finishingHour(finishingHour)
                .build();
    }

}
