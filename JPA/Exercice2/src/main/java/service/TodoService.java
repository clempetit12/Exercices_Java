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

            if (toDoDao.addTask(task)) {
                System.out.println("Une tâche a bien été ajoutée avec succès !");
            }
        return task;

    }

    public List<Task> displayTasks() {
            return toDoDao.displayTasks();

    }

    public boolean declareTaskCompleteed (Long id) {

            if (toDoDao.taskCompleteed(id)) {
                System.out.println("La tâche a bien été modifiée");
            }
        return true;
    }

    public  boolean deleteTask(Long id) {

            if (toDoDao.removeTask(id)) {
                System.out.println("La tâche a bien été supprimée");

        }
        return true;
    }

    public void close() {
        toDoDao.close();
    }


}
