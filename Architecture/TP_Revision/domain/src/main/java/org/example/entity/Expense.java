package org.example.entity;

import java.time.LocalTime;
import java.util.Date;

public class Expense {

    private Long id;

    private String title;

    private double amount;

    private Expense(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.amount = builder.amount;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    public static class Builder {
        private Long id;
        private String title;
        private double amount;


        public Builder id(Long id) {
            this.id = id;
            return this;

        }
        public Builder title(String title) {
            this.title = title;
            return this;

        }

        public Builder amount(double amount) {
            this.amount = amount;
            return this;

        }

        public Expense build() {
            return new Expense(this);
        }
    }



}
