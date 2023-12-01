package org.example.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;


@Data
@NoArgsConstructor
public class Event {
    private String nameEvent;
    private LocalDate date;
    private LocalTime hour;
    private Location location;
    private String locationName;
    private int price;
    private int numberOfTicketsSold;

    private static HashMap<String, Event> bdd = new HashMap<>();

    public Event(String nameEvent, LocalDate date, LocalTime hour, String locationName, int price, int numberOfTicketsSold) {
        this.nameEvent = nameEvent;
        this.date = date;
        this.hour = hour;
        this.location = Location.getLocation(locationName);
        this.price = price;
        this.numberOfTicketsSold = numberOfTicketsSold;
        bdd.put(nameEvent, this);
    }

    public static boolean checkDisponibilityTicket(String eventName) {
        Event eventWished = bdd.get(eventName);
        if (eventWished != null) {
            long capacity = eventWished.location.getCapacity();
            long realCapacity = capacity - eventWished.numberOfTicketsSold;
            System.out.println("La capacité réelle est de :" + realCapacity);
            return eventWished.numberOfTicketsSold < realCapacity;
        } else {
            System.out.println("Il n'y a pas d'évènements ");
            return false;
        }

    };

    public void sellTicket(String eventName) {
        if (checkDisponibilityTicket(eventName)) {
            numberOfTicketsSold++;
            System.out.println("Le nombre de tickets vendus s'élèvent à " + numberOfTicketsSold);
        }
        ;
    };

    public void cancelTicket() {
        numberOfTicketsSold--;
        System.out.println("Le nombre de tickets vendus s'élèvent à " + numberOfTicketsSold);
    }
    public static void modifyEvent(String nameEvent, LocalDate date, LocalTime hour, String locationName, int price, int numberOfTicketsSold) {
        Event eventUpdate = bdd.get(nameEvent);

        if (eventUpdate != null) {
            eventUpdate.setDate(date);
            eventUpdate.setHour(hour);
            eventUpdate.setLocationName(locationName);
            eventUpdate.setPrice(price);
            eventUpdate.setNumberOfTicketsSold(numberOfTicketsSold);
            System.out.println("Evenement modifié avec succès !");
        } else {
            System.out.println("Evenement non trouvé. La modification a échoué.");
        }
    }
    public static void displayAllEvents() {

        for (Event event : bdd.values()) {
            System.out.println(event);
        }}
    public static void deleteEvent(String name) {
        Event eventToDelete = bdd.get(name);

        if (eventToDelete != null) {
            bdd.remove(name);
            System.out.println("L'évènement a été supprimé avec succès !");

        } else {
            System.out.println("Evenement non trouvé. La suppression a échoué.");
        }
    }

    @Override
    public String toString() {
        return "Event{" +
                "nameEvent='" + nameEvent + '\'' +
                ", date=" + date +
                ", hour=" + hour +
                ", location=" + location +
                ", price=" + price +
                ", numberOfTicketsSold=" + numberOfTicketsSold +
                '}';
    }
};




