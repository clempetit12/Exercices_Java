package dao;

import entity.Category;
import entity.Task;
import entity.TaskInfo;
import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.Date;
import java.util.List;

public class CategoryDao extends BaseDao<Category> {

    private EntityManagerFactory emf;

    public CategoryDao(EntityManagerFactory entityManagerFactory) {
        this.emf = entityManagerFactory;
    }
    @Override
    public boolean add(Category element) {
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
            Category category = em.find(Category.class, id);
            em.remove(category);
            transaction.commit();
            System.out.println("La catégorie a été supprimée avec succès");

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

    public boolean addaddTaskToCategory(Long taskId, Long categoryId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Task task = em.find(Task.class, taskId);
            Category category = em.find(Category.class,categoryId);
            category.getTaskList().add(task);
            em.merge(category);

            transaction.commit();
            System.out.println("La tâche a été ajoutée avec succès");

            return true;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    public Category findCategory(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            return em.find(Category.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean removeTaskFromCategory(Long taskId, Long categoryId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            Task task = em.find(Task.class, taskId);
            Category category = em.find(Category.class, categoryId);
            category.getTaskList().remove(task);
            em.merge(category);

            transaction.commit();
            System.out.println("La tâche a été retirée de la catégorie avec succès");

            return true;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    public void close() {
        emf.close();
    }
}
