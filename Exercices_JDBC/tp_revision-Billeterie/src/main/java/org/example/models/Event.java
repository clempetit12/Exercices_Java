package org.example.models;

import lombok.*;
import org.example.dao.LocationDao;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    
    private int id;
    private String name;
    private LocalDate date;
    private LocalTime hour;
    private int idLocation;
    private  float price;
    private int numberticketsSold=0;



    public Event(String name, LocalDate date, LocalTime hour, int idLocation, float price, int numberticketsSold) {
        this.name = name;
        this.date = date;
        this.hour = hour;
        this.idLocation = idLocation;
        this.price = price;
        this.numberticketsSold = numberticketsSold;
    }



    public Event(int id, String name, int numberticketsSold) {
        this.id = id;
        this.name = name;
        this.numberticketsSold = numberticketsSold;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




    public boolean annulerBillet(){
        if(this.numberticketsSold == 0){
            System.out.println("il n'y a eu aucun billet vendu pour cette evenement");
            return false;
        }
        else{
            this.numberticketsSold --;
            System.out.println("le billet a bien ete annuler");
            return true;
        }
    }



    public int getnumberticketsSold() {
        return numberticketsSold;
    }

    public void setnumberticketsSold(int numberticketsSold) {
        this.numberticketsSold = numberticketsSold;
    }

    @Override
    public String toString() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return "Evenement{" +
                "name='" + name + '\'' +
                ", date=" + date.format(dateFormatter) +
                ", hour='" + hour.format(timeFormatter) + '\'' +
                ", lieu=" + idLocation +
                ", price=" + price +
                ", numberticketsSold=" + numberticketsSold +
                '}';
    }


}
