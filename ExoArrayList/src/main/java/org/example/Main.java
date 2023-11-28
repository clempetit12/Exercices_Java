package org.example;

import org.example.classes.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Book> booklist = new ArrayList<Book>();
        ArrayList<Emprunt> empruntList = new ArrayList<Emprunt>();

        LocalDate dateChoisie = LocalDate.of(2023, 11, 28);


        Library library = new Library(booklist, empruntList);


        PaperBook book = new PaperBook("Danser", "Steinbeck", 500, "Hachette");
        PaperBook book2 = new PaperBook("1984", "Steinbeck", 500, "Hachette");
        NumericBook book3 = new NumericBook("Rêver", "Frank Thilliez", Format.EPUB, 300);
        NumericBook book4 = new NumericBook("Le bleu du ciel", "Melissa Costa", Format.PDF, 400);

        library.addBook(book);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);


        //Affichage livres bibliothèques et taille bibliothèque
        System.out.println("Les livres dans la bibliothèque ");
        for (Book b : booklist) {
            System.out.println(b);
        }
        System.out.println();
        System.out.println("La taille de la bibliothèque avant retrait livre : " + booklist.size());

        //Suppression book2
        library.removeBook(book2);
        System.out.println("La taille de la bibliothèque après retrait livre est : " + booklist.size());
        System.out.println();

        //Affichage livres bibliothèques après retrait
        System.out.println("Les livres dans la bibliothèque ");
        for (Book b : booklist) {
            System.out.println(b);
        }

        System.out.println();
//Trouver livre par titre
        System.out.println("Le livre par titre : ");
        library.findBookbyTitle("Danser");
        System.out.println();

        //Trouver livre par auteur
        System.out.println("Lelivre par auteur : ");
        library.findBookbyAuthor("Melissa Costa");
        System.out.println();

        //Emprunter un livre

        Person person = new Person("Clara", "Taram");
        Person person2 = new Person("Athéna", "Sapi");


        library.empruntBook(book, person);
        library.empruntBook(book2, person2);

        System.out.println("Liste emprunt  : ");
        for (Emprunt e : empruntList) {
            System.out.println(e);
        }

        System.out.println();
        // Retourner le livre
        LocalDate dateFictive = LocalDate.of(2023, 06, 01);

        System.out.println("Liste emprunt après avoir rendu le livre : ");
        //library.returnBook(book2, dateFictive);
        for (Emprunt e : empruntList) {
            System.out.println(e);
        }

        library.empruntBook(book,person2);
    }


}