package dao;

import entity.Agency;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class AggencyDao implements BaseDao<Agency> {

    private EntityManagerFactory emf;

    public AggencyDao(EntityManagerFactory entityManagerFactory) {
        this.emf = entityManagerFactory;
    }
    @Override
    public boolean add(Agency element) {
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
    public boolean delete(Long id) {
return false;
    }

    @Override
    public void close() {
        emf.close();
    }

    @Override
    public Agency find(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Agency agency = em.find(Agency.class,id);
            transaction.commit();
            return agency;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return null;

        }
    }


}
