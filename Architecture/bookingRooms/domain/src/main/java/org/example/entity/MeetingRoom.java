package org.example.entity;

import java.time.LocalTime;
import java.util.Date;
import java.util.Timer;

public class MeetingRoom {
    private Long id;
    private boolean availibility;
    private int capacity;



    private MeetingRoom(Builder builder) {
        this.id = builder.id;
        this.availibility = builder.availibility;
        this.capacity = builder.capacity;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAvailibility() {
        return availibility;
    }

    public void setAvailibility(boolean availibility) {
        this.availibility = availibility;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


public static class Builder {
    private Long id;
    private boolean availibility = true;
    private int capacity;

    private Date date;

    private LocalTime beginningHour;

    private LocalTime finishingHour;


    public Builder id(Long id) {
        this.id = id;
        return this;

    }
    public Builder capacity(int capacity) {
        this.capacity = capacity;
        return this;

    }

    public Builder availibility(boolean availibility) {
        this.availibility = availibility;
        return this;

    }

    public MeetingRoom build() {
        return new MeetingRoom(this);
    }
}

}
