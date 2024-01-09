package dao;

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

public class ProductDao implements ProductDaoI {

    private SessionFactory sessionFactory;

    public ProductDao() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        this.sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }


    @Override
    public boolean createProduct(Product product) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.getTransaction().begin();
            session.save(product);
            System.out.println("Le produit a été créée avec id " + product.getIdProduct());
            sessionFactory.getCurrentSession().close();
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public Product getProductById(Long id) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.getTransaction().begin();
            Query<Product> productQuery = session.createQuery("from Product where id = ?1", Product.class);
            productQuery.setParameter(1, id);
            Product product = productQuery.uniqueResult();
            session.getTransaction().commit();
            System.out.println("Le produit avec  id " + id + " est " + product.getReference());
            return product;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.getTransaction().begin();
            Product product = getProductById(id);


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
    public boolean updateProduct(Long id, String brand, String reference, Date purchaseDate, Double price, int stock) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.getTransaction().begin();
            Product product = getProductById(id);
            if (product != null) {
                product.setBrand(brand);
                product.setReference(reference);
                product.setPurchaseDate(purchaseDate);
                product.setPrice(price);
                product.setStock(stock);
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
    public List<Product> getAllProducts() {
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
    public List<Product> getProductsByPrice(Double price) {
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
    public List<Product> getproductsByDate(Date date1, Date date2) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.getTransaction().begin();
            List<Product> productList = new ArrayList<>();
            Query<Product> productQuery = session.createQuery("from Product where purchaseDate between :date1 and :date2");
            productQuery.setParameter("date1", date1);
            productQuery.setParameter("date2", date2);
            productList = productQuery.list();
            return productList;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return null;
    }


}
