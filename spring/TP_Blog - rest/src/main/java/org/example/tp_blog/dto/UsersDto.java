package org.example.tp_blog.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.tp_blog.entity.Post;
import org.example.tp_blog.entity.Users;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDto {

    private int id;

    @NotNull
    private String email;

    @NotNull
    private String password;

    private String role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Users toUsers() {
        Users users = new Users();
        users.setId(id);
      users.setEmail(email);
      users.setPassword(password);
      users.setRole(role);
        return users;
    }
}
