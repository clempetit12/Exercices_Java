import java.util.Arrays;
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

    public static void getSolution51() {
        int[] tab = {1, 2, 3, 1, 2, 3, 3, 7, 2, 4, 7};
        int[] tabOccurences = new int[tab.length];
        boolean[] compte = new boolean[tab.length];

        for (int i = 0; i < tab.length; i++) {
            if (!compte[i]) {
                for (int j = i + 1; j < tab.length; j++) {
                    if (tab[i] == tab[j]) {
                        tabOccurences[i]++;
                        compte[j] = true;
                    }
                }
                compte[i] = true;
            }
        }

        System.out.println("TabOccurences : ");
        for (int i = 0; i < tab.length; i++) {
            if (tabOccurences[i] > 0) {
                System.out.println(tab[i] + " : " + tabOccurences[i]);
            }
        }
    }

    public static void getSolution52() {

        boolean ordonne = true;
        int[] tab = {1,2,3,4,5};

        for (int i = 0; i < tab.length-1; i++) {
            if (tab[i]>tab[i+1]) {
                ordonne = false;
            }
        }
        if (!ordonne) {
            System.out.println("Le tableau d'entier n'est pas trié par ordre croissant !");
        } else {
            System.out.println("Le tableau d'entier est trié par ordre croissant !");
        }

    }

    public static void getSolution53() {
        int[] tab = {10,1000,16,16,90};
       int plusGrandEcart = 0;
       int ecart;

        for (int i = 0; i < tab.length; i++) {
            for (int j = i +1; j < tab.length; j++) {
                ecart= Math.abs(tab[i] -tab[j] );
                if (ecart>plusGrandEcart) {
                    plusGrandEcart = ecart;

                }

            }
        }
        System.out.println("Le plus grand écart est de " + plusGrandEcart);

    }

    public static void getSolutionExo54(){
        int[] tab = {10,1000,16,16,90};
        int premiereValeur;
        premiereValeur = tab[tab.length-1];
        for (int i = tab.length-1; i>0; i--) {
                tab[i] = tab[i-1] ;
            }
        tab[0] = premiereValeur;
        System.out.println("Tab : " + Arrays.toString(tab));
        }



}
