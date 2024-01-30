package org.example.entity;

import lombok.Builder;

@Builder
public class Car {

    int rentDueIn;
    int condition;
    String category;



    public int getRentDueIn() {
        return rentDueIn;
    }

    public void setRentDueIn(int rentDueIn) {
        this.rentDueIn = rentDueIn;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
