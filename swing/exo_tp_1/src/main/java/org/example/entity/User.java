package org.example.entity;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {

    private String name;
    private String email;
private String gendra;

    public User(String name, String email, String gendra) {
        this.name = name;
        this.email = email;
        this.gendra = gendra;
    }
}
