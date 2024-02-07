package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "meetingRoom")
public class MeetingRoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_meeting_room", nullable = false)
    private Long idMeetingRoom;


    private boolean availibility;
    private int capacity;

    @ManyToMany(mappedBy ="meetingRoomList" )
    private List<UserEntity> userList;

    @OneToMany(mappedBy = "meetingRoom")
    private List<ReservationEntity> reservationList;


    public MeetingRoom toMeetingRoom() {
        return new MeetingRoom.Builder().capacity(capacity).build();
    }

}
