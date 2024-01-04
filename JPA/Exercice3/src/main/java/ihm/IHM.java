package ihm;

import com.mysql.cj.log.Log;
import entity.Task;
import entity.TaskInfo;
import entity.User;
import service.TodoService;
import service.UserService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class IHM {

    private Scanner scanner = new Scanner(System.in);
    private int choix;
    private static TodoService todoService = new TodoService();
    private static UserService userService = new UserService();

    public IHM() {
    }

    public void start() {
        do {
            printMenu();
            choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1:
                    CreateUserAndTask();
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
                case 5:
                    updateTask();
                    break;
                case 7:
                    addTaskToUser();
                    break;
                case 8:
                    displayTasksUser();
                    break;
                case 9:
                    removeUserAndTask();
                    break;
                case 0:
                    closeAll();
                    break;
                default:
                    System.out.println("choix invalide !");
            }

        } while (choix != 0);
    }

    private void removeUserAndTask() {
        System.out.println("Précisez l'id de l'utilisateur :");
        Long id = scanner.nextLong();
        userService.removeUser(id);
    }

    private void displayTasksUser() {
        System.out.println("Précisez l'id de l'utilisateur :");
        Long id = scanner.nextLong();
        User user = userService.findUser(id);
        for (Task t: user.getTaskList()
             ) {
            System.out.println(t);

        }
    }

    private void addTaskToUser() {
        try{
        System.out.println("Précisez l'id de l'utilisateur :");
        Long id = scanner.nextLong();
        User user = userService.findUser(id);
        System.out.println("Combien de tâches souhaitez vous ajouter ");
        int nombreTache = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < nombreTache; i++) {
            System.out.println("Veuillez indiquer le nom de la tâche");
            String title = scanner.nextLine();
            System.out.println("Veuillez indiquer la description de la  tâche");
            String description = scanner.nextLine();
            System.out.println("Veuillez indiquer la dateButoire de la tâche (format dd-MM-yyyy)");
            String date_string = scanner.next();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date date = formatter.parse(date_string);
            System.out.println("Veuillez indiquer la priorité");
            Integer priority = scanner.nextInt();
            scanner.nextLine();
            TaskInfo taskInfo = new TaskInfo();
            taskInfo.setPriorityTask(priority);
            taskInfo.setDescription(description);
            taskInfo.setFinishDate(date);
            Task task = new Task(title, taskInfo);
            task.setUser(user);
            todoService.createTask(task);
            user.add(task);

        }

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }


    }





    private void CreateUserAndTask() {
        try {

            System.out.println("Veuillez préciser le nom de l'utilisateur : ");
            String userName = scanner.nextLine();
            User user = new User(userName);
            System.out.println("Veuillez indiquer le nom de la tâche");
            String title = scanner.nextLine();
            System.out.println("Veuillez indiquer la description de la  tâche");
            String description = scanner.nextLine();
            System.out.println("Veuillez indiquer la dateButoire de la tâche (format dd-MM-yyyy)");
            String date_string = scanner.next();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date date = formatter.parse(date_string);
            System.out.println("Veuillez indiquer la priorité");
            Integer priority = scanner.nextInt();
            scanner.nextLine();
            userService.addUser(user);
            todoService.createTaskOnly(title, description, date, priority, user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    private void updateTask() {
        try {
            System.out.println("Veuillez indiquer l'id de la tâche que vous souhaitez modifier :");
            Long id = scanner.nextLong();
            scanner.nextLine();
            System.out.println("Veuillez indiquer le nouveau titre : ");
            String title = scanner.nextLine();
            System.out.println("Veuillez indiquer la description de la  tâche");
            String description = scanner.nextLine();
            System.out.println("Veuillez indiquer la dateButoire de la tâche (format dd-MM-yyyy)");
            String date_string = scanner.next();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date date = formatter.parse(date_string);
            System.out.println("Veuillez indiquer la priorité");
            Integer priority = scanner.nextInt();
            scanner.nextLine();
            todoService.updateTask(id, title, description, date, priority);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

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


    private void closeAll() {
        todoService.close();
    }


    private void printMenu() {
        System.out.println("=== ToDo ===");
        System.out.println("1. Création d'un utilisateur et d'une tâche");
        System.out.println("2. Suppression d'une tâche ");
        System.out.println("3. Modification d'une tâche en tant que complétée");
        System.out.println("4. Affichage de toutes les tâches");
        System.out.println("5. Modification d'une tâche");
        System.out.println("6. Ajout d'un utilisateur ");
        System.out.println("7. Ajouter une tâche à un utilisateur");
        System.out.println("8. Afficher les tâches d'un utilisateur");
        System.out.println("9. Supprimer un utilisateur");
        System.out.println("0. Quitter");
        System.out.println("Saisissez votre choix :");

    }
}
