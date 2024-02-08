package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_user", nullable = false)
    private Long idUser;

    private String firstName;
    private String lastName;

    private UsersEnum usersEnum;

    @ManyToMany(mappedBy = "userList")
    private List<MeetingRoomEntity> meetingRoomList;
    @OneToMany(mappedBy = "user")
    private List<ReservationEntity> reservationEntityList;


    public User toUser() {
        return new User.Builder().firstName(firstName).lastName(lastName)
                .userEnum(usersEnum).build();
    }
}
