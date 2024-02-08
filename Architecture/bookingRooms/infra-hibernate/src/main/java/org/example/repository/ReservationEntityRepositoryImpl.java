package org.example.repository;


import org.example.entity.*;
import org.example.port.ReservationRepository;
import org.example.utils.HibernateSession;
import org.hibernate.Session;

import java.util.List;

public class ReservationEntityRepositoryImpl implements ReservationRepository {

    private ReservationEntityRepository reservationEntityRepository;

    public ReservationEntityRepositoryImpl() {
        reservationEntityRepository = new ReservationEntityRepository();
    }
    @Override
    public boolean create(Reservation reservation) {
        Session session = HibernateSession.getSessionFactory().openSession();
        reservationEntityRepository.setSession(session);
        session.beginTransaction();
        try {
            UserEntity userEntity = session.get(UserEntity.class, reservation.getUserId());
            MeetingRoomEntity meetingRoomEntity = session.get(MeetingRoomEntity.class,reservation.getMeetingRoomId());
            ReservationEntity reservationEntity = ReservationEntity.builder().beginningHour(reservation.getBeginningHour())
                            .finishingHour(reservation.getFinishingHour())
                                    .user(userEntity)
                                            .date(reservation.getDate())
                                                    .meetingRoom(meetingRoomEntity).build();
            session.getTransaction().commit();
            reservation.setId(reservationEntity.getIdReservation());
            return true;

        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public Reservation findById(Long id) {
        return null;
    }

    @Override
    public List<Reservation> findAll() {
        return null;
    }
}
