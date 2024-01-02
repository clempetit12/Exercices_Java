package ihm;

import service.TodoService;

import java.util.Scanner;

public class IHM {

    private Scanner scanner = new Scanner(System.in);
    private int choix;
    private static TodoService todoService = new TodoService();

    public IHM() {
    }

    public void start() {
        do {
            printMenu();
            choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1:
                    AddTodo();
                    break;
                case 2:
                    RemoveTodo();
                    break;
                case 3:
                    updateTodo();
                    break;
                case 4:
                    displayTodo();
                    break;
                case 0:
                    scanner.close();
                    break;
                default:
                    System.out.println("choix invalide !");
            }

        }while (choix != 0);
    }

    private void displayTodo() {
        todoService.displayTasks();
    }

    private void updateTodo() {
        System.out.println("Veuillez indiquer l'id de la tâche que vous souhaitez marquer comme complétée :");
        Long id = scanner.nextLong();
        todoService.declareTaskCompleteed(id);
    }

    private void RemoveTodo() {
        System.out.println("Veuillez indiquer l'id de la tâche à supprimer :");
        Long id = scanner.nextLong();
        todoService.deleteTask(id);
    }

    private void AddTodo() {
        System.out.println("Veuillez indiquer le nom de la tâche");
        String title = scanner.nextLine();
        todoService.createTask(title);
    }

    private void createTodo() {



    }


    private void printMenu() {
        System.out.println("=== ToDo ===");
        System.out.println("1. Ajout d'une tâche");
        System.out.println("2. Suppression d'une tâche ");
        System.out.println("3. Modification d'une tâche");
        System.out.println("4. Affichage de toutes les tâches");
        System.out.println("0. Quitter");
        System.out.println("Saisissez votre choix :");

    }
}
