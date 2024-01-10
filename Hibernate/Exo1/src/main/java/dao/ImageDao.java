package dao;

import entity.Image;
import entity.Product;
import interfaces.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Date;
import java.util.List;

public class ImageDao implements Repository<Image> {

    private SessionFactory sessionFactory;

    public ImageDao() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        this.sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }
    @Override
    public boolean create(Image element) {
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
    public boolean update(Long id, Image element) {
        return false;
    }


    public boolean updateImage(Long id, Product element) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Image image = getById(id);
            if (image != null) {
              image.setProduct(element);
                session.update(image);
                session.getTransaction().commit();
            }
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
    public void delete(Long id) {

    }

    @Override
    public Image getById(Long id) {
        Session session = null;

        try {
            session = sessionFactory.openSession();
            Image image = (Image) session.load(Image.class, id);
            return image;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();

        }
        return null;
    }

    @Override
    public List<Image> getAll() {
        return null;
    }

    @Override
    public List<Image> getByPrice(Double price) {
        return null;
    }

    @Override
    public List<Image> getByDate(Date date1, Date date2) {
        return null;
    }

    @Override
    public List<Image> getByStock(int stock) {
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
