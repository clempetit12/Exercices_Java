package com.example.adapter.resource;

import com.example.adapter.dto.UserDto;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.example.entity.User;
import org.example.entity.UsersEnum;
import org.example.repository.UserEntityRepositoryImpl;
import org.example.service.UserService;

@Path("user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    private final UserService userService;


    public UserResource() {
         userService = new UserService(new UserEntityRepositoryImpl());
    }

    @POST
    public User post(UserDto userDto) {
        String firstName = userDto.getFirstName();
        String lastName = userDto.getLastName();
        UsersEnum usersEnum = userDto.getUsersEnum();
        return userService.create(firstName,lastName,usersEnum);
    }
}
