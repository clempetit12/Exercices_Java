package org.example.maison;

public class Porte {

    String color;

    public Porte(String color) {
        if (color == "") {
           this.color = "bleu";
        } else {
            this.color = color;
        }

    }




    public String getColor() {
        return color;
    }


    public void setColor(String color) {
        this.color = color;
    }

    public void displayDoor() {
        System.out.println("Je suis une porte, ma couleur est " + getColor());
    }

    @Override
    public String toString() {
        return "Je suis une porte, ma couleur est " +
                color
                ;
    }
}
