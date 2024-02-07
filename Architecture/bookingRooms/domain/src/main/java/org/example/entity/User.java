package org.example.entity;

import java.time.LocalTime;
import java.util.Date;

public class User {

    private Long id;
private String firstName;
private String lastName;

private UsersEnum usersEnum;

    private User(Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.usersEnum = builder.usersEnum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UsersEnum getUsersEnum() {
        return usersEnum;
    }

    public void setUsersEnum(UsersEnum usersEnum) {
        this.usersEnum = usersEnum;
    }

    public static class Builder {
        private Long id;
        private String firstName;
        private String lastName;

        private UsersEnum usersEnum;



        public User.Builder id(Long id) {
            this.id = id;
            return this;

        }
        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;

        }
        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;

        }

        public Builder userEnum(UsersEnum lastName) {
            this.usersEnum = usersEnum;
            return this;

        }
        public User build() {
            return new User(this);
        }

    }


}
