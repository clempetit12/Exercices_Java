package org.example.service;

import org.example.entity.MeetingRoom;
import org.example.exception.MeetingRoomException;
import org.example.port.MeetingRoomRepository;
import org.example.port.UserRepository;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public class MeetingRoomService {

    private final MeetingRoomRepository meetingRoomRepository;


    public MeetingRoomService(MeetingRoomRepository meetingRoomRepository) {
        this.meetingRoomRepository = meetingRoomRepository;

    }

    public MeetingRoom create(int capacity) {
        MeetingRoom meetingRoom = new MeetingRoom.Builder().capacity(capacity).build();
        meetingRoomRepository.create(meetingRoom);
        return meetingRoom;

    }

    public MeetingRoom getMeetingRoomById(Long id) {
        MeetingRoom meetingRoom = meetingRoomRepository.findById(id);
        if (meetingRoom != null) {
            return meetingRoom;
        }
        throw new MeetingRoomException();

    }

    public MeetingRoom update(Long id, MeetingRoom meetingRoom) {
        MeetingRoom meetingRoomToBeUpdated = meetingRoomRepository.findById(id);
        meetingRoomToBeUpdated.setCapacity(meetingRoom.getCapacity());
        meetingRoomToBeUpdated.setAvailibility(meetingRoom.isAvailibility());
        meetingRoomToBeUpdated.setId(meetingRoomToBeUpdated.getId());
        meetingRoomRepository.update(meetingRoom);
        return meetingRoomToBeUpdated;

    }

    public boolean delete(Long id) {
        MeetingRoom meetingRoom = meetingRoomRepository.findById(id);
        if (meetingRoom != null) {
            return meetingRoomRepository.delete(meetingRoom);
        }
        throw new MeetingRoomException();

    }

    public List<MeetingRoom> searchAvailableRooms(Date date, LocalTime beginningHour, LocalTime finishingHour, int capacity) {
        List<MeetingRoom> meetingRoomList = meetingRoomRepository.searchAvailableMeetingRoom(date,beginningHour,finishingHour,capacity);
        throw new MeetingRoomException();

    }

}
