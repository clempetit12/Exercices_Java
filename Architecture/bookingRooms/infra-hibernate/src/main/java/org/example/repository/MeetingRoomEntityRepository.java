package org.example.repository;

import org.example.entity.MeetingRoom;
import org.example.entity.MeetingRoomEntity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public class MeetingRoomEntityRepository extends BaseEntityRepository<MeetingRoomEntity> {
    @Override
    MeetingRoomEntity findById(Long id) {
        return session.get(MeetingRoomEntity.class,id);
    }

    @Override
    List<MeetingRoomEntity> findAll() {
        return session.createQuery("from MeetingRoomEntity ", MeetingRoomEntity.class).list();
    }

    List<MeetingRoomEntity> searchAvailableRoom(LocalDate date, LocalTime beginningHour, LocalTime finishingHour, int capacity, boolean availibility){
        return session.createQuery("select m from MeetingRoomEntity m " +
                        "where m.availibility = :availibility " +
                        "and m.capacity >= :capacity " +
                        "and not exists (select r from ReservationEntity r " +
                        "where r.meetingRoom = m " +
                        "and (:date between r.date and r.date) " +
                        "and (:beginningHour between r.beginningHour and r.finishingHour " +
                        "or :finishingHour between r.beginningHour and r.finishingHour))", MeetingRoomEntity.class)
                .setParameter("availability", availibility)
                .setParameter("capacity", capacity)
                .setParameter("date", date)
                .setParameter("beginningHour", beginningHour)
                .setParameter("finishingHour", finishingHour)
                .getResultList();
    }

}
