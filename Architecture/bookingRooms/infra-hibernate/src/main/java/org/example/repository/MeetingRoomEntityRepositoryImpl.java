package org.example.repository;

import org.example.entity.MeetingRoom;
import org.example.entity.MeetingRoomEntity;
import org.example.port.MeetingRoomRepository;
import org.example.utils.HibernateSession;
import org.hibernate.Session;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;


public class MeetingRoomEntityRepositoryImpl implements MeetingRoomRepository {

    private MeetingRoomEntityRepository meetingRoomEntityRepository;

    public MeetingRoomEntityRepositoryImpl() {
        meetingRoomEntityRepository = new MeetingRoomEntityRepository();
    }
    @Override
    public boolean create(MeetingRoom meetingRoom) {
        Session session = HibernateSession.getSessionFactory().openSession();
        meetingRoomEntityRepository.setSession(session);
        session.beginTransaction();
        try {
            MeetingRoomEntity meetingRoomEntity = MeetingRoomEntity.builder().
                    capacity(meetingRoom.getCapacity()).build();
            session.getTransaction().commit();
            meetingRoom.setId(meetingRoomEntity.getIdMeetingRoom());
            return true;

        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public boolean update(MeetingRoom meetingRoom) {
        return false;
    }

    @Override
    public boolean delete(MeetingRoom meetingRoom) {
        return false;
    }

    @Override
    public MeetingRoom findById(Long id) {
        return null;
    }

    @Override
    public List<MeetingRoom> findAll() {
        return null;
    }

    @Override
    public List<MeetingRoom> searchAvailableMeetingRoom(Date date, LocalTime beginningHour, LocalTime finishingHour, int capacity) {
        Session session = HibernateSession.getSessionFactory().openSession();
        meetingRoomEntityRepository.setSession(session);
        session.beginTransaction();
        try {
            MeetingRoomEntity meetingRoomEntity = meetingRoomEntityRepository
            session.getTransaction().commit();
            meetingRoom.setId(meetingRoomEntity.getIdMeetingRoom());
            return true;

        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
    }
}
