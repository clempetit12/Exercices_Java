package dao;

import entity.Orders;
import entity.Product;
import interfaces.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdersDao implements Repository<Orders> {

    private SessionFactory sessionFactory;

    public OrdersDao() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        this.sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    @Override
    public boolean create(Orders element) {
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
    public boolean update(Long id, Orders element) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Orders orders = getById(id);
            if (orders != null) {
               orders.setAdress(element.getAdress());
                session.update(orders);
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
    public Orders getById(Long id) {
        Session session = null;

        try {
            session = sessionFactory.openSession();
            Orders orders = (Orders) session.get(Orders.class, id);
            return orders;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();

        }
        return null;
    }

    @Override
    public List<Orders> getAll() {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            List<Orders> orderList = session.createQuery(
                    "SELECT DISTINCT o FROM Orders o LEFT JOIN FETCH o.productList",
                    Orders.class
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
    public List<Orders> getByPrice(Double price) {
        return null;
    }

    @Override
    public List<Orders> getByDate(Date date1, Date date2) {
        return null;
    }

    @Override
    public List<Orders> getByStock(int stock) {
        return null;
    }

    @Override
    public Double getAveragePrice() {
        return null;
    }

    @Override
    public void close() {

    }

    public List<Orders> getorderByDate(Date date){
        Session session = null;
        try {
            session = sessionFactory.openSession();
            List<Orders> orderList = new ArrayList<>();
            Query<Orders> orderQuery = session.createQuery(" from Orders where orderPurchase = :date");
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
