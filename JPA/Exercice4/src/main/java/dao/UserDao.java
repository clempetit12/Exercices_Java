package dao;

import entity.Task;
import entity.TaskInfo;
import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

public class UserDao extends BaseDao<User> {

    private EntityManagerFactory emf;

    public UserDao(EntityManagerFactory entityManagerFactory) {
        this.emf = entityManagerFactory;
    }

    @Override
    public boolean add(User element) {
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

    @Override
    public List<Task> display() {
        return null;
    }

    @Override
    public boolean taskCompleteed(Long id) {
        return false;
    }

    @Override
    public boolean remove(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            User user = em.find(User.class, id);
            em.remove(user);
            transaction.commit();
            System.out.println("L'utilisateur a été supprimé avec succès");

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
        return false;
    }

    @Override
    public boolean addTaskInfo(TaskInfo element) {
        return false;
    }

    public User findUser(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            return em.find(User.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void close() {
        emf.close();
    }
}

