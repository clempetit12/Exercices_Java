package org.example.service;

import org.example.entity.MeetingRoom;
import org.example.entity.User;
import org.example.entity.UsersEnum;
import org.example.port.MeetingRoomRepository;
import org.example.port.UserRepository;

public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public User create(String firstName, String lastName, UsersEnum role) {
       User user = new User.Builder().firstName(firstName).lastName(lastName).userEnum(role).build();
       userRepository.create(user);
        return user;

    }
}
