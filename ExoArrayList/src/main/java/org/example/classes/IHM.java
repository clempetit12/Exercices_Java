package org.example.classes;

import org.example.Format;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class IHM {

    private static Scanner scanner = new Scanner(System.in);

    private static ArrayList<Book> libraryList = new ArrayList<>();
    private static ArrayList<Emprunt> empruntList = new ArrayList<>();
    private static ArrayList<Person> personnesEmprunt = new ArrayList<>();
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
        PaperBook book2 = new PaperBook("Danser", "Frank Thilliez", 500, "Hachette");
        NumericBook book3 = new NumericBook("Rêver", "Frank Thilliez", Format.EPUB, 300);
        NumericBook book4 = new NumericBook("Le bleu du ciel", "Melissa Costa", Format.PDF, 400);
        PaperBook book5 = new PaperBook("La chambre des sorciers", "J K Rowling", 500, "Hachette");
        PaperBook book6 = new PaperBook("Passe Muraille", "Marcel Aymé", 500, "Hachette");
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
            System.out.println("4 - Retourner un livre ");
            System.out.println("4 - Retourner liste des emprunts ");
            System.out.println("Veuillez indiquer votre choix :");
            choix = parseInt(scanner.nextLine());

            switch (choix) {
                case 1:
                    findBookTitle();
                    break;
                case 2:
                    findBookAuthor();
                    break;
                case 3:
                    borrowBook();
                    break;
                case 4:
                    returnedBook();
                    break;
                case 5:
                    displayListEmprunt();
                    break;


            }
            System.out.println();
        }
    }

    public static void findBookTitle() {
        String title;
        System.out.println("Quel est le titre du livre que vous souhaitez trouver ?");
        title = scanner.nextLine();
        library.findBookbyTitle(title);

    }

    public static void findBookAuthor() {
        String author;
        System.out.println("Quel auteur cherchez vous ?");
        author = scanner.nextLine();
        library.findBookbyAuthor(author);

    }

    public static void borrowBook() {
        System.out.println("Quel livre souhaitez vous emprunter ?");
        System.out.println("Veuillez indiquer le titre recherché : ");
        String title = scanner.nextLine();
        System.out.println("Veuillez indiquer l'auteur recherché : ");
        String author = scanner.nextLine();
        System.out.println("Quel est votre prénom ?");
        String firstname = scanner.nextLine();
        System.out.println("Quel est votre nom ?");
        String lastname = scanner.nextLine();

        Person newPerson = new Person(firstname, lastname);
       Book foundbook = null;
        boolean bookFound = false;
        for (Book b : libraryList) {
            if ((title.toLowerCase().contains(b.getTitle().toLowerCase())) && (author.toLowerCase().contains(b.getAuthor().toLowerCase()))) {
                foundbook = b;
                bookFound = true;
                System.out.println(foundbook);

            }
        }
        if (bookFound) {
            library.empruntBook(foundbook, newPerson);

        } else {
            System.out.println("Il n'y a pas de livre correspondant ");
        }
    }

    public static void returnedBook() {
        System.out.println("veuillez renseigner l'année' : ");
        int year = parseInt(scanner.nextLine());
        System.out.println("veuillez renseigner le mois : ");
        int month = parseInt(scanner.nextLine());
        System.out.println("veuillez renseigner le jour : ");
        int day = parseInt(scanner.nextLine());

        LocalDate dateFictive = LocalDate.of(year, month, day);

        System.out.println("Quel livre souhaitez-vous retourner ? ");
        System.out.println("Titre ? ");
        String title = scanner.nextLine();
        System.out.println("Auteur ? ");
        String author = scanner.nextLine();
        int idBookFound = 0;
        boolean bookFound = false;
        for (Emprunt e : empruntList) {
            if (title.toLowerCase().contains(e.getBook().getTitle().toLowerCase()) && author.toLowerCase().contains(e.getBook().getAuthor().toLowerCase())) {
                idBookFound = e.getBook().getId();
                bookFound = true;
                System.out.println(e);

            }

        }
        library.returnBook(idBookFound, dateFictive);
    }

    public static void displayListEmprunt() {
        for (Emprunt e : empruntList) {
            System.out.println(e);
        }
    }


}
