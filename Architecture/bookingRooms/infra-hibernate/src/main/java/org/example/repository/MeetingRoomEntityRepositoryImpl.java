package org.example.repository;

import org.example.entity.MeetingRoom;
import org.example.entity.MeetingRoomEntity;
import org.example.port.MeetingRoomRepository;
import org.example.utils.HibernateSession;
import org.hibernate.Session;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


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
        Session session = HibernateSession.getSessionFactory().openSession();
        meetingRoomEntityRepository.setSession(session);
        session.beginTransaction();
        try {
            MeetingRoomEntity meetingRoomEntity = meetingRoomEntityRepository.findById(meetingRoom.getId());
            meetingRoomEntity.setCapacity(meetingRoomEntity.getCapacity());
            session.merge(meetingRoomEntity);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public boolean delete(MeetingRoom meetingRoom) {
        Session session = HibernateSession.getSessionFactory().openSession();
        meetingRoomEntityRepository.setSession(session);
        session.beginTransaction();
        try {
            MeetingRoomEntity meetingRoomEntity = meetingRoomEntityRepository.findById(meetingRoom.getId());
            if(meetingRoomEntity != null){
                meetingRoomEntityRepository.delete(meetingRoomEntity);
            }
            session.getTransaction().commit();
            return true;

        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public MeetingRoom findById(Long id) {

        Session session = HibernateSession.getSessionFactory().openSession();
        meetingRoomEntityRepository.setSession(session);
        session.beginTransaction();
        try {
            MeetingRoomEntity meetingRoomEntity = meetingRoomEntityRepository.findById(id);
            if (meetingRoomEntity != null) {
                MeetingRoom meetingRoom = meetingRoomEntity.toMeetingRoom();
                return meetingRoom;
            }
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
        return null;
    }

    @Override
    public List<MeetingRoom> findAll() {
        return null;
    }

    @Override
    public List<MeetingRoom> searchAvailableMeetingRoom(LocalDate date, LocalTime beginningHour, LocalTime finishingHour, int capacity, boolean availibility) {
        Session session = HibernateSession.getSessionFactory().openSession();
        meetingRoomEntityRepository.setSession(session);
        session.beginTransaction();
        try {
            List< MeetingRoomEntity> meetingRoomEntities  = meetingRoomEntityRepository.searchAvailableRoom(date,beginningHour,finishingHour,capacity,availibility);
            List<MeetingRoom> meetingRoomList = meetingRoomEntities.stream().map(meetingRoomEntity -> meetingRoomEntity.toMeetingRoom())
                    .collect(Collectors.toList());
            session.getTransaction().commit();
            return meetingRoomList;

        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
    }


}
