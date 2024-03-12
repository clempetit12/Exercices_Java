package dao;

import entity.Adress;
import interfaces.DaoImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

@Entity
public class AdressDao implements DaoImpl<Adress> {

    private SessionFactory sessionFactory;

    public AdressDao() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        this.sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }


    @Override
    public boolean create(Adress element) {
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
    public boolean update(Long id, Adress element) {
        return false;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Adress getById(Long id) {
        return null;
    }

    @Override
    public List<Adress> getAll() {
        return null;
    }

    @Override
    public List<Adress> getByPrice(Double price) {
        return null;
    }

    @Override
    public List<Adress> getByDate(Date date1, Date date2) {
        return null;
    }

    @Override
    public List<Adress> getByStock(int stock) {
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
