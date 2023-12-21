package org.example.models;

import org.example.dao.LocationDao;

import java.sql.Time;
import java.util.Date;

public class Event {
    
    private int id;
    private String name;
    private Date date;
    private Time hour;
    private int idLocation;
    private  float price;
    private int numberticketsSold=0;


    public Event(int id, String name, Date date, Time hour, int idLocation, float price, int numberticketsSold) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.hour = hour;
        this.idLocation = idLocation;
        this.price = price;
        this.numberticketsSold = numberticketsSold;
    }

    public Event(String name, Date date, Time hour, int idLocation, float price, int numberticketsSold) {
        this.name = name;
        this.date = date;
        this.hour = hour;
        this.idLocation = idLocation;
        this.price = price;
        this.numberticketsSold = numberticketsSold;
    }

    public Event(String name, Date date, Time hour, int idLocation, float price) {
        this.name = name;
        this.date = date;
        this.hour = hour;
        this.idLocation = idLocation;
        this.price = price;
        this.numberticketsSold = 0;
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


    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time gethour() {
        return hour;
    }

    public void sethour(Time hour) {
        this.hour = hour;
    }

    public int getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }

    public float getprice() {
        return price;
    }

    public void setprice(float price) {
        this.price = price;
    }

    public int getnumberticketsSold() {
        return numberticketsSold;
    }

    public void setnumberticketsSold(int numberticketsSold) {
        this.numberticketsSold = numberticketsSold;
    }

    @Override
    public String toString() {
        return "Evenement{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", hour='" + hour + '\'' +
                ", lieu=" + idLocation +
                ", price=" + price +
                ", numberticketsSold=" + numberticketsSold +
                '}';
    }


}
