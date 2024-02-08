package org.example.service;

import org.example.entity.Reservation;
import org.example.exception.ReservationException;
import org.example.port.ReservationRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public class ReservationService {


    private final ReservationRepository reservationRepository;


    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public boolean create(Long meetingRoomId, Long userId, LocalDate date, LocalTime beginningHour, LocalTime finishingHour) {
        Reservation reservation = new Reservation.Builder().meetingRoomId(meetingRoomId)
                .userId(userId)
                .date(date)
                .beginningHour(beginningHour)
                .finishingHour(finishingHour)
                .build();
       if(reservationRepository.create(reservation)) {
           return true;
       }
        throw new ReservationException();
    }

    public List<Reservation> getAllReservations() {
        return  reservationRepository.findAll();
    }


}
