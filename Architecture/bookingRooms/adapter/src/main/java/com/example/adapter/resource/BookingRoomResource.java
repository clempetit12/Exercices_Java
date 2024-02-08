package com.example.adapter.resource;

import com.example.adapter.dto.MeetingRoomDto;
import com.example.adapter.dto.ReservationDto;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.entity.MeetingRoom;
import org.example.entity.Reservation;
import org.example.repository.MeetingRoomEntityRepositoryImpl;
import org.example.repository.ReservationEntityRepositoryImpl;
import org.example.repository.UserEntityRepositoryImpl;
import org.example.service.MeetingRoomService;
import org.example.service.ReservationService;
import org.example.service.UserService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Path("booking")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BookingRoomResource {

    private final MeetingRoomService meetingRoomService;

    private final ReservationService reservationService;

    private final UserService userService;


    public BookingRoomResource() {
        meetingRoomService = new MeetingRoomService(new MeetingRoomEntityRepositoryImpl());
        reservationService = new ReservationService(new ReservationEntityRepositoryImpl());
        userService = new UserService(new UserEntityRepositoryImpl());
    }

    @GET
    @RolesAllowed("UsersEnum.ADMINISTRATOR")
    public List<ReservationDto> reservationList() {
        List<Reservation> reservationList = reservationService.getAllReservations();
        return reservationList.stream().map(reservation -> ReservationDto.builder().meetingRoomId(reservation.getMeetingRoomId())
                .id(reservation.getId()).build()).collect(Collectors.toList());
    }

    @GET
    @Path("/searchAvailableRoom")
    public List<MeetingRoomDto> meetingRoomsAvailable(LocalDate date, LocalTime beginningHour, LocalTime finishingHour, int capacity, boolean availibility) {
        List<MeetingRoom> meetingRoomList = meetingRoomService.searchAvailableRooms(date,beginningHour,finishingHour,capacity,availibility);
        return meetingRoomList.stream().map(meetingRoom -> MeetingRoomDto.builder()
                .capacity(capacity)
                .build()).collect(Collectors.toList());
    }

    @POST
    @Path("/reservationRoom")
    public boolean doReservation(LocalDate date, LocalTime beginningHour,LocalTime finishingHour,Long meetingRoomId, Long userId){
       if(reservationService.create(meetingRoomId,userId,date,beginningHour,finishingHour)){
           return true;
        }
        return false;
    }

    @POST
    @RolesAllowed("UsersEnum.ADMINISTRATOR")
    @Path("/rooms")
    public MeetingRoomDto createMeetingRoom(int capacity){
      MeetingRoom meetingRoom = meetingRoomService.create(capacity);
        return MeetingRoomDto.builder().capacity(capacity).build();
    }

    @PATCH
    @RolesAllowed("UsersEnum.ADMINISTRATOR")
    @Path("{id}")
    public MeetingRoom get(@PathParam("id") Long id, int capacity, boolean availibility) {
     return   meetingRoomService.update(id,capacity,availibility);


    }

    @DELETE
    @RolesAllowed("UsersEnum.ADMINISTRATOR")
    @Path("{id}")
    public boolean delete(@PathParam("id") Long id) {
         if(meetingRoomService.delete(id)) {
            return true;
        }
        return false;


    }








}
