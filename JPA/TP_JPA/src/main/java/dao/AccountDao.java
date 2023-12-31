package dao;

import entity.Account;
import entity.Agency;
import entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

public class AccountDao implements BaseDao<Account> {

    private EntityManagerFactory emf;

    public AccountDao(EntityManagerFactory entityManagerFactory) {
        this.emf = entityManagerFactory;
    }
    @Override
    public boolean add(Account element) {
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

        }finally {
            em.close();
        }
    }

    @Override
    public boolean delete(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Account account = em.find(Account.class, id);

            if (account != null) {
                List<Customer> customerList = account.getCustomerList();
                for (Customer customer : customerList) {
                    customer.getAccountList().remove(account);
                }
                account.setCustomerList(null);
                em.remove(account);
                transaction.commit();
                System.out.println("Le compte a été supprimé avec succès");
                return true;
            } else {
                System.out.println("Aucun compte trouvé avec l'ID spécifié.");
                return false;
            }
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            em.close();

        }
    }


    @Override
    public void close() {
        emf.close();
    }

    @Override
    public Account find(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Account account = em.find(Account.class,id);
            transaction.commit();
            return account;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        }finally {
            em.close();
        }
    }

    public void addCustomerToAccount(Long customerId, Long accountId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            Customer customer = em.find(Customer.class, customerId);
            Account account = em.find(Account.class, accountId);

            account.getCustomerList().add(customer);
            customer.getAccountList().add(account);

            em.merge(account);
            em.merge(customer);

            transaction.commit();
            System.out.println("Le client a bien été ajouté au compte avec succès");
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }



    public void createAccount(Account account, Long idCustomer, Long idAgency) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Agency agency = em.find(Agency.class, idAgency);
            Customer customer = em.find(Customer.class, idCustomer);
            agency.getAccountList().add(account);
            customer.getAccountList().add(account);
            em.persist(account);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Erreur lors de la création du compte associé à l'agence et au client", e);
        } finally {
            em.close();

        }
    }

}
