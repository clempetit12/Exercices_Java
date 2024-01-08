package dao;

import entity.Account;
import entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao implements BaseDao<Customer> {

    private EntityManagerFactory emf;

    public CustomerDao(EntityManagerFactory entityManagerFactory) {
        this.emf = entityManagerFactory;
    }

    @Override
    public boolean add(Customer element) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(element);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;

        }

    }

    @Override
        public boolean delete (Long id){
            EntityManager em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();

            try {
                transaction.begin();
                Customer customer = em.find(Customer.class, id);
                if (customer != null) {
                    List<Account> accountList = customer.getAccountList();
                    for (Account account : accountList) {
                        account.getCustomerList().remove(customer);
                    }
                    customer.setAccountList(null);
                    em.remove(customer);
                    transaction.commit();
                    System.out.println("Le client a été supprimé avec succès");
                    return true;
                } else {
                    System.out.println("Aucun client trouvé avec l'ID spécifié.");
                    return false;
                }
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

    @Override
    public void close() {
        emf.close();
    }

    @Override
    public Customer find(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Customer customer = em.find(Customer.class,id);
            transaction.commit();
            return customer;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return null;

        }
    }
}
