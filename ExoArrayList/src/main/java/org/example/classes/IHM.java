package org.example.classes;

import org.example.Format;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IHM {

    private static Scanner scanner = new Scanner(System.in);

    private static ArrayList<Book> libraryList = new ArrayList<>();
    private static ArrayList<Emprunt> empruntList = new ArrayList<>();
    private static Library library = new Library(libraryList, empruntList);

    public static void start() {
        System.out.println("== Bienvenue à la bibliothèque des merveilles ==");
        initialisationLibrary();

        System.out.println();
        System.out.println("Voici les livres présents dans la bibliothèque ");
        for (Book b : libraryList) {
            System.out.println(b);
        }
        printMenu();
    }

    public static void initialisationLibrary() {

        PaperBook book = new PaperBook("Danser", "Steinbeck", 500, "Hachette");
        PaperBook book2 = new PaperBook("1984", "Steinbeck", 500, "Hachette");
        NumericBook book3 = new NumericBook("Rêver", "Frank Thilliez", Format.EPUB, 300);
        NumericBook book4 = new NumericBook("Le bleu du ciel", "Melissa Costa", Format.PDF, 400);
        PaperBook book5 = new PaperBook("La chambre des sorciers", "J.K.Rowling", 500, "Hachette");
        PaperBook book6 = new PaperBook("PasseMuraille", "Marcel Aymé", 500, "Hachette");
        libraryList.add(book);
        libraryList.add(book2);
        libraryList.add(book3);
        libraryList.add(book4);
        libraryList.add(book5);
        libraryList.add(book6);

    }

    public static void printMenu() {
        int choix;

        while (true) {
            System.out.println("==== Menu ====");
            System.out.println("1 - Trouver livre par titre ");
            System.out.println("2 - Trouver livre par auteur ");
            System.out.println("3 - Emprunter un livre ");
            System.out.println("3 - Retourner un livre ");

            System.out.println("Veuillez indiquer votre choix :");
            choix = scanner.nextInt();

            switch (choix) {
                case 1:findBookBytitle();
                break;


            }
        }
    }

    public static void findBookBytitle() {
        String title;
        System.out.println("Quel est le titre du livre que vous souhaitez trouver ?");
        title = scanner.nextLine();
        library.findBookbyTitle(title);

    }


}
