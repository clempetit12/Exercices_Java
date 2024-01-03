package service;

import dao.ToDoDao;
import entity.Task;
import entity.TaskInfo;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class TodoService {

    private static ToDoDao toDoDao = new ToDoDao();

    public Task createTask(String title, String description, Date finishDate, Integer priority) {
        TaskInfo taskInfo = new TaskInfo();
        taskInfo.setDescription(description);
        taskInfo.setFinishDate(finishDate);
        taskInfo.setPriorityTask(priority);
        Task task = new Task(title,taskInfo);
        try {
            if (toDoDao.addTask(task)) {
                System.out.println("Une tâche a bien été ajoutée avec succès !");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());


        }
        return task;

    }

    public List<Task> displayTasks() {

        try {
            return toDoDao.displayTasks();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean declareTaskCompleteed (Long id) {
        try {
            if (toDoDao.taskCompleteed(id)) {
                System.out.println("La tâche a bien été modifiée");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public  boolean deleteTask(Long id) {
        try {
            if (toDoDao.removeTask(id)) {
                System.out.println("La tâche a bien été supprimée");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }



}
