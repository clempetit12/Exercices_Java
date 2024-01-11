package dao;

import interfaces.Repository;
import entity.Product;
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

public class ProductDao implements Repository<Product> {

    private SessionFactory sessionFactory;

    public ProductDao() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        this.sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }


    @Override
    public boolean create(Product element) {
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
    public boolean update(Long id, Product element) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Product product = getById(id);
            if (product != null) {
                product.setBrand(element.getBrand());
                product.setReference(element.getReference());
                product.setPurchaseDate(element.getPurchaseDate());
                product.setPrice(element.getPrice());
                product.setStock(element.getStock());
                product.setImageList(element.getImageList());
                product.setCommentsList(element.getCommentsList());
                session.update(product);
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
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Product product = getById(id);


            if (product != null) {
                session.delete(product);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();

        }
    }

    @Override
    public Product getById(Long id) {
        Session session = null;

        try {
            session = sessionFactory.openSession();
            Product product = (Product) session.get(Product.class, id);
            return product;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();

        }
        return null;
    }


    @Override
    public List<Product> getAll() {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            List<Product> productList = new ArrayList<>();
            Query<Product> productQuery = session.createQuery(" SELECT DISTINCT p FROM Product p LEFT JOIN FETCH p.commentsList\n");
            productList = productQuery.list();
            return productList;

        } catch (Exception e) {
            e.printStackTrace();
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
            List<Product> productList = new ArrayList<>();
            Query<Product> productQuery = session.createQuery(" from Product where price > :price ");
            productQuery.setParameter("price", price);
            productList = productQuery.list();
            return productList;

        } catch (Exception e) {
            e.printStackTrace();
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
            List<Product> productList = new ArrayList<>();
            if (date1.before(date2)) {
                Query<Product> productQuery = session.createQuery("from Product where purchaseDate between :date1 and :date2");
                productQuery.setParameter("date1", date1);
                productQuery.setParameter("date2", date2);
                productList = productQuery.list();
                return productList;
            } else {
                System.out.println("La " + date1 + " n'est pas avant la " + date2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<Product> getByStock(int stock) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            List<Product> productList = new ArrayList<>();
            if (stock > 0) {
                Query<Product> productQuery = session.createQuery("from Product where stock < :stock");
                productQuery.setParameter("stock", stock);
                productList = productQuery.list();

                return productList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public List<Double> getValueStockBrand(String brand) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            List<Double> stockList = new ArrayList<>();
            Query<Double> stockQuery = session.createQuery("select (stock*price) from Product where brand like :brand");
            stockQuery.setParameter("brand", brand);
            stockList = stockQuery.list();
            return stockList;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public Double getTotalValueStock(String brand) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Query<Double> stockQuery = session.createQuery("select sum(stock*price) from Product where brand like :brand");
            stockQuery.setParameter("brand", brand);
            Double totalValueStock = stockQuery.uniqueResult();
            return totalValueStock;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Double getAveragePrice() {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Query<Double> productQuery = session.createQuery("select avg(price) from Product");
            double averagePrice = productQuery.uniqueResult();
            return averagePrice;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public List<Product> getProductsFromBrand(String brand) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            List<Product> productList = new ArrayList<>();
            Query<Product> productQuery = session.createQuery("from Product where brand like :brand");
            productQuery.setParameter("brand", brand);
            productList = productQuery.list();
            return productList;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public void deleteProductBrand(String brand) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            List<Product> productList = getProductsFromBrand(brand);
            for (Product p: productList
                 ) {
                session.delete(p);
            }


            session.getTransaction().commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();

        }
    }

    @Override
    public void close() {
        sessionFactory.close();
    }

    public List<Product> getProductsByGrade(int grade) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            List<Product> productList = new ArrayList<>();
            Query<Product> productQuery = session.createQuery(
                    "SELECT DISTINCT p FROM Product p " +
                            "LEFT JOIN FETCH p.commentsList c " +
                            "WHERE EXISTS (SELECT c FROM p.commentsList c WHERE c.grade > :grade)", Product.class
            );
               productQuery.setParameter("grade",grade);
                productList = productQuery.list();
                return productList;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
}
