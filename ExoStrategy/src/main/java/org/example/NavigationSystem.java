package org.example;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NavigationSystem {

private String destination;

public void drive(NavigationStrategy navigationStrategy){
    if(navigationStrategy.navigate(destination) ) {
        System.out.println("Stratégie de navigation modifiée avec succès !");

    } else {
        System.out.println("Stratégie de navigation n'a pas pu être modifiée !");
    }


}
}
