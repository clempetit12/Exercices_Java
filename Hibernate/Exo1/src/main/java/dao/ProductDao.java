package dao;

import Interfaces.Repository;
import entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductDao implements Repository<Product> {

    private SessionFactory sessionFactory;

    public ProductDao() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        this.sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }



    @Override
    public boolean create(Product element) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.getTransaction().begin();
            session.save(element);
            System.out.println("Le produit a été créée avec id " + element.getIdProduct());
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();

        }
        return false;
    }

    @Override
    public Product getById(Long id) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.getTransaction().begin();
            Product product = (Product) session.load(Product.class,id);
            session.getTransaction().commit();
            return product;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();

        }
        return null;
    }

    @Override
    public void delete(Long id) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.getTransaction().begin();
            Product product = getById(id);


            if (product != null) {
                session.delete(product);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();

        }
    }

    @Override
    public boolean update(Long id, Product element) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.getTransaction().begin();
            Product product = getById(id);
            if (product != null) {
                product.setBrand(element.getBrand());
                product.setReference(element.getReference());
                product.setPurchaseDate(element.getPurchaseDate());
                product.setPrice(element.getPrice());
                product.setStock(element.getStock());
                session.update(product);
                session.getTransaction().commit();
            }
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();

        }
        return false;
    }

    @Override
    public List<Product> getAll() {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.getTransaction().begin();
            List<Product> productList = new ArrayList<>();
            Query<Product> productQuery = session.createQuery(" from Product");
            productList = productQuery.list();

            return productList;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();

        }
        return null;
    }

    @Override
    public List<Product> getByPrice(Double price) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.getTransaction().begin();
            List<Product> productList = new ArrayList<>();
            Query<Product> productQuery = session.createQuery(" from Product where price > :price ");
            productQuery.setParameter("price", price);
            productList = productQuery.list();
            return productList;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();

        }
        return null;
    }

    @Override
    public List<Product> getByDate(Date date1, Date date2) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.getTransaction().begin();
            List<Product> productList = new ArrayList<>();
            if(date1.before(date2)) {
                Query<Product> productQuery = session.createQuery("from Product where purchaseDate between :date1 and :date2");
                productQuery.setParameter("date1", date1);
                productQuery.setParameter("date2", date2);
                productList = productQuery.list();
                return productList;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public void close() {
        sessionFactory.close();
    }


}
