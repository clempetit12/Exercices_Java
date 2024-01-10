package dao;

import entity.Comments;
import entity.Image;
import interfaces.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Date;
import java.util.List;

public class CommentDao implements Repository<Comments> {

    private SessionFactory sessionFactory;

    public CommentDao() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        this.sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }
    @Override
    public boolean create(Comments element) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(element);
            session.getTransaction().commit();
            return true;

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();

        }
        return false;
    }

    @Override
    public boolean update(Long id, Comments element) {
        return false;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Comments getById(Long id) {
        Session session = null;

        try {
            session = sessionFactory.openSession();
            Comments comments = (Comments) session.load(Comments.class, id);
            return comments;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();

        }
        return null;
    }

    @Override
    public List<Comments> getAll() {
        return null;
    }

    @Override
    public List<Comments> getByPrice(Double price) {
        return null;
    }

    @Override
    public List<Comments> getByDate(Date date1, Date date2) {
        return null;
    }

    @Override
    public List<Comments> getByStock(int stock) {
        return null;
    }

    @Override
    public Double getAveragePrice() {
        return null;
    }

    @Override
    public void close() {

    }


}
