package dao;

import entity.Task;
import entity.TaskInfo;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


public class ToDoDao extends BaseDao<Task> {

    private EntityManagerFactory emf;

    public ToDoDao(EntityManagerFactory entityManagerFactory) {
        this.emf = entityManagerFactory;
    }

    @Override
    public boolean add(Task element) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(element);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;

        }
    }

    @Override
    public List<Task> display() {
        List<Task> taskList = null;
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            taskList = em.createQuery("select t from Task t", Task.class).getResultList();

            for (Task t : taskList) {
                System.out.println(t);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return taskList;
    }


    @Override
    public boolean taskCompleteed(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Task task = em.find(Task.class, id);
            task.setCompleteed(true);
            transaction.commit();
            System.out.println("La tâche est terminée avec id " + id);

            return true;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean remove(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Task task = em.find(Task.class, id);
            em.remove(task);
            transaction.commit();
            System.out.println("La tâche a été supprimée avec succès");


            return true;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Long id, String title, String description, Date endingDate, Integer priority) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Task task = em.find(Task.class, id);
            if (task != null) {
                task.setTitle(title);

            }
            TaskInfo taskInfo = task.getTaskInfo();
            if(taskInfo != null) {
                taskInfo.setDescription(description);
                taskInfo.setFinishDate(endingDate);
                taskInfo.setPriorityTask(priority);
            }

            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean addTaskInfo(TaskInfo element) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(element);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    public void close() {

        emf.close();
    }


}
