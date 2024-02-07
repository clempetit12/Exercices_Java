package org.example.entity;

import java.time.LocalTime;
import java.util.Date;

public class Reservation {

    private Long id;
    private Long meetingRoomId;

    private Long userId;

    private Date date;

    private LocalTime beginningHour;

    private LocalTime finishingHour;


    private Reservation(Builder builder) {
        this.id = builder.id;
        this.meetingRoomId = builder.meetingRoomId;
        this.userId = builder.userId;
        this.date = builder.date;
        this.beginningHour = builder.beginningHour;
        this.finishingHour = builder.finishingHour;

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMeetingRoomId() {
        return meetingRoomId;
    }

    public void setMeetingRoomId(Long meetingRoomId) {
        this.meetingRoomId = meetingRoomId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public LocalTime getBeginningHour() {
        return beginningHour;
    }

    public void setBeginningHour(LocalTime beginningHour) {
        this.beginningHour = beginningHour;
    }

    public LocalTime getFinishingHour() {
        return finishingHour;
    }

    public void setFinishingHour(LocalTime finishingHour) {
        this.finishingHour = finishingHour;
    }



    public static class Builder {
        private Long id;
        private Long meetingRoomId;

        private Long userId;

        private Date date;

        private LocalTime beginningHour;

        private LocalTime finishingHour;

        public Builder id(Long id) {
            this.id = id;
            return this;

        }
        public Builder meetingRoomId(Long meetingRoomId) {
            this.meetingRoomId = meetingRoomId;
            return this;

        }
        public Builder userId(Long userId) {
            this.userId = userId;
            return this;

        }
        public Builder date(Date date) {
            this.date = date;
            return this;

        }
        public Builder beginningHour(LocalTime beginningHour) {
            this.beginningHour = beginningHour;
            return this;

        }

        public Builder finishingHour(LocalTime finishingHour) {
            this.finishingHour = finishingHour;
            return this;

        }


        public Reservation build() {
            return new Reservation(this);
        }
    }

}
