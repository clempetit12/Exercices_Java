package dao;

import entity.Comment;
import interfaces.DaoImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Date;
import java.util.List;

public class CommentDao implements DaoImpl<Comment> {

    private SessionFactory sessionFactory;

    public CommentDao() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        this.sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }
    @Override
    public boolean create(Comment element) {
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
    public boolean update(Long id, Comment element) {
        return false;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Comment getById(Long id) {
        Session session = null;

        try {
            session = sessionFactory.openSession();
            Comment comment = (Comment) session.load(Comment.class, id);
            return comment;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();

        }
        return null;
    }

    @Override
    public List<Comment> getAll() {
        return null;
    }

    @Override
    public List<Comment> getByPrice(Double price) {
        return null;
    }

    @Override
    public List<Comment> getByDate(Date date1, Date date2) {
        return null;
    }

    @Override
    public List<Comment> getByStock(int stock) {
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
