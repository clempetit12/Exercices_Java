package org.example.port;

import org.example.entity.MeetingRoom;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Timer;

public interface MeetingRoomRepository {

    boolean create(MeetingRoom meetingRoom);
    boolean update(MeetingRoom meetingRoom);
    boolean delete(MeetingRoom meetingRoom);

    MeetingRoom findById(Long id);

    List<MeetingRoom> findAll();
    List<MeetingRoom> searchAvailableMeetingRoom(Date date, LocalTime beginningHour, LocalTime finishingHour, int capacity, boolean availibility);


}
