package org.example.entity;

import org.example.exception.ConditionException;

public class Agency {
    public void dailyRoutine(Car car) {

        if(car.getRentDueIn()<0) {
            car.setCondition(car.getCondition()-2);
        } else if (car.getCondition()<0 || car.getCondition()>100) {
            throw new ConditionException();
        }


        else {
            car.setCondition(car.getCondition() - 1);
            car.setCondition(car.getCondition()-1);
        }
        if (car.getCategory().equals("luxury")) {
            car.setCondition(car.getCondition()+1);
        }


    }
}
