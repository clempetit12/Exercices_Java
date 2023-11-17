import java.util.Random;
import java.util.Scanner;

public class Tableau {

    public static Scanner scanner = new Scanner(System.in);
    public static void getSolutionExo1() {
        int[] tab = {1,2,3,4,5};
        System.out.println("La valeur de la troisième case du tableau est : " + tab[2]);

    }

    public static void getSolutionExo2() {
        int[] tab = {1,2,3,4,5,6,7,8,9,10};

        for (int i = 1; i <tab.length ; i++) {
            System.out.println("La valeur de la case " + i + " du tableau est " + tab[i]);

        }



    }

    public static void getSolutionExo3() {
        int[] tab = {10,20,30,40,50,60,70,80};
        int nombre;
        boolean found = false;
        System.out.println("Veuillez saisir un entier à rechercher dans le tableau : ");
        nombre = scanner.nextInt();

        for (int numb:tab) {
            if (numb == nombre){
                found = true;
                System.out.println("L'entier est présent dans le tableau !");
                break;
            }

        }
        if (!found) {
            System.out.println("L'entier n'est pas présent dans le tableau !");
        }
        scanner.close();



    }

    public static void getSolutionExo4(){
        int [] tab = new int[6];
        boolean found = false;
        for (int i = 0; i < tab.length; i++) {
            System.out.println("Veuillez saisir un nombre à l'emplacement " + i + " : " );
            tab[i] = scanner.nextInt();

        }
        for (int numb:tab) {
            if ((numb%2 != 0)){
                found = true;

            }
        }
        if (!found) {
            System.out.println("Tous les éléments sont pairs ");
        } else {
            System.out.println("Au moins un élément est impair");
        }




    }

    public static void getSolutionExo5() {
        int[] tab = new int[10];
        Random nombreAleatoire = new Random();


        for (int i = 0; i < tab.length ; i++) {
       tab[i] = nombreAleatoire.nextInt(100);
            System.out.println("L'élément du tableau en position " + i + " est " + tab[i]);
        }


    }

    public static void getSolutionExo6() {
        int[] tab1 = new int[5];
        int[] tab2 = new int[5];
        int[] tab3 = new int[5];
        int sum;
        Random nombreAleatoire = new Random();

        for (int i = 0; i < tab1.length; i++) {
            tab1[i] = nombreAleatoire.nextInt(100);
            tab2[i] = nombreAleatoire.nextInt(100);
tab3[i] = tab1[i] +tab2[i];

            System.out.println("Tab1 : " + tab1[i]);
            System.out.println("Tab2 : " + tab2[i]);
            System.out.println("Tab3 : " + tab3[i]);

        }

    }

    public static void getSolutionExo7() {
        int[] tab = new int[10];
        Random nombreAleatoire = new Random();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < tab.length; i++) {
            tab[i] = nombreAleatoire.nextInt(100);
            System.out.println("L'élément du tableau en position " + i + " est " + tab[i]);
        }
        for (int numb: tab) {
            if (numb>max) {
                max = numb;
            }
        }
        System.out.println("Le plus grand élément du tableau est : " + max);


    }
}
