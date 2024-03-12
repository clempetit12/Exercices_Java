package dao;

import entity.Order;
import interfaces.DaoImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdersDao implements DaoImpl<Order> {

    private SessionFactory sessionFactory;

    public OrdersDao() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        this.sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    @Override
    public boolean create(Order element) {
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
    public boolean update(Long id, Order element) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Order order = getById(id);
            if (order != null) {
               order.setAdress(element.getAdress());
                session.update(order);
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
    public Order getById(Long id) {
        Session session = null;

        try {
            session = sessionFactory.openSession();
            Order order = (Order) session.get(Order.class, id);
            return order;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();

        }
        return null;
    }

    @Override
    public List<Order> getAll() {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            List<Order> orderList = session.createQuery(
                    "SELECT DISTINCT o FROM Order o \n" +
                            "LEFT JOIN FETCH o.productList p\n",
                    Order.class
            ).getResultList();

            return orderList;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return null;
    }



    @Override
    public List<Order> getByPrice(Double price) {
        return null;
    }

    @Override
    public List<Order> getByDate(Date date1, Date date2) {
        return null;
    }

    @Override
    public List<Order> getByStock(int stock) {
        return null;
    }

    @Override
    public Double getAveragePrice() {
        return null;
    }

    @Override
    public void close() {

    }

    public List<Order> getorderByDate(Date date){
        Session session = null;
        try {
            session = sessionFactory.openSession();
            List<Order> orderList = new ArrayList<>();
            Query<Order> orderQuery = session.createQuery(" from Order where orderPurchase = :date");
            orderQuery.setParameter("date", date);
            orderList = orderQuery.list();
            return orderList;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();

        }
        return null;

    }
}
