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
            System.out.println("La valeau de la case " + i + " du tableau est " + tab[i]);

        }



    }

    public static void getSolutionExo3() {
        int[] tab = new int[10,20,30,40,50,60,70,80];
        int nombre;


    }
}
