package org.example.port;

import org.example.entity.MeetingRoom;
import org.example.entity.Reservation;
import org.example.entity.User;

public interface UserRepository {

    boolean create(User user);
    User findById(Long id);


}
