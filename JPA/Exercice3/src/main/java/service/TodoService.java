package service;

import dao.ToDoDao;
import dao.UserDao;
import entity.Task;
import entity.TaskInfo;
import entity.User;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class TodoService {

    private  ToDoDao toDoDao;
    public TodoService(ToDoDao toDoDao) {
        this.toDoDao = toDoDao;
    }
    public Task createTask(Task task) {
            if (toDoDao.add(task)  ) {
                System.out.println("Une tâche a bien été créé   !");
            }
        return task;

    }

    public Task createTaskOnly(String title, String description, Date finishDate, Integer priority, User user) {
        TaskInfo taskInfo = new TaskInfo();
        taskInfo.setDescription(description);
        taskInfo.setFinishDate(finishDate);
        taskInfo.setPriorityTask(priority);
        Task task = new Task(title,taskInfo);
task.setUser(user);
        if (toDoDao.add(task)) {
            System.out.println("Une tâche a bien été ajoutée avec succès !");
        }
        return task;

    }

    public List<Task> displayTasks() {
            return toDoDao.display();

    }

    public boolean declareTaskCompleteed (Long id) {

            if (toDoDao.taskCompleteed(id)) {
                System.out.println("La tâche a bien été modifiée");
            }
        return true;
    }

    public  boolean deleteTask(Long id) {

            if (toDoDao.remove(id)) {
                System.out.println("La tâche a bien été supprimée");

        }
        return true;
    }

    public void close() {
        toDoDao.close();
    }

    public boolean updateTask(Long id, String title, String description, Date endingDate, Integer priority) {
        if (toDoDao.update(id, title,description,endingDate,priority)) {
            System.out.println("La tâche a bien été modifiée");

        }
        return true;
    }


}
