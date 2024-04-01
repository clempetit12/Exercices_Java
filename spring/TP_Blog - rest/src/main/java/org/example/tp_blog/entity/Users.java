package org.example.tp_blog.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.example.tp_blog.dto.PostDto;
import org.example.tp_blog.dto.UsersDto;

@Entity
@ToString
@Data
@EqualsAndHashCode
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    
    private String email;

    private String password;

    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public UsersDto toUsersDto() {
        UsersDto usersDto = new UsersDto();
     usersDto.setId(this.id);
     usersDto.setEmail(this.email);
     usersDto.setPassword(this.password);
     usersDto.setRole(this.role);
     return usersDto;
    }
}
