package org.example.repository;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public class MeetingRoomEntityRepository extends BaseEntityRepository<MeetingRoomEntityRepository> {
    @Override
    MeetingRoomEntityRepository findById(Long id) {
        return session.get(MeetingRoomEntityRepository.class,id);
    }

    @Override
    List<MeetingRoomEntityRepository> findAll() {
        return session.createQuery("from MeetingRoomEntity ", MeetingRoomEntityRepository.class).list();
    }

    List<MeetingRoomEntityRepository> searchAvailableRoom(Date date, LocalTime beginningHour, LocalTime finishingHour, int capacity, boolean availibility){
        return session.createQuery("select m from MeetingRoomEntity where m.availi ")
    }
}
