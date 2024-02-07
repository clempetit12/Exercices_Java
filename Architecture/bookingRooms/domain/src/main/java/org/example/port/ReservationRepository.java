package org.example.port;

import org.example.entity.MeetingRoom;
import org.example.entity.Reservation;

import java.util.List;

public interface ReservationRepository {
    boolean create(Reservation reservation);

    Reservation findById(Long id);

    List<Reservation> findAll();

}
