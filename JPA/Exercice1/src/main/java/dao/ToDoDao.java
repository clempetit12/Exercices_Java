package dao;

import entity.Task;

import javax.persistence.*;
import java.util.List;


public class ToDoDao extends BaseDao<Task> {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("todoList");
    private static EntityManager em = emf.createEntityManager();
    private static EntityTransaction transaction = em.getTransaction();

    @Override
    public boolean addTask(Task element) {
        transaction.begin();
        em.persist(element);
        String completedStatus = element.isCompleteed() ? "complété" : "en cours";
        element.setCompleteedString(completedStatus);
        transaction.commit();
        return true;
    }

    @Override
    public List<Task> displayTasks() {
        transaction.begin();
        List<Task> taskList = null;
        taskList = em.createQuery("select t from Task t", Task.class).getResultList();
        for (Task t : taskList) {
            System.out.println(t);
        }
        transaction.commit();

        return taskList;
    }

    @Override
    public boolean taskCompleteed(Long id) {
        transaction.begin();
        Task task = em.find(Task.class, id);
        task.setCompleteed(true);
        String completedStatus = task.isCompleteed() ? "complété" : "en cours";
        task.setCompleteedString(completedStatus);
        transaction.commit();
        System.out.println("La tâche est terminée avec id " + id);

        return true;
    }

    @Override
    public boolean removeTask(Long id) {
        transaction.begin();
        Task task = em.find(Task.class, id);
        em.remove(task);
        transaction.commit();
        System.out.println("La tâche a été supprimée avec succès");


        return true;
    }

    public void closeEntity() {
        if (em != null && em.isOpen()) {
            em.close();
        }

        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }


}
