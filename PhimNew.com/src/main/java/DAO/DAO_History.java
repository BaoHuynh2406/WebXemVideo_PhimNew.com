package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import Entity.History;
import Utils.JpaUtils;

public class DAO_History extends DAO<History, Integer> {

    @Override
    public void insert(History entity) {
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void update(History entity) {
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void delete(Integer key) {
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            History history = entityManager.find(History.class, key);
            entityManager.remove(history);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<History> findAll() {
        EntityManager entityManager = JpaUtils.getEntityManager();
        List<History> histories = null;
        try {
            histories = entityManager.createQuery("SELECT h FROM History h", History.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return histories;
    }

    @Override
    public History findByID(Integer key) {
        EntityManager entityManager = JpaUtils.getEntityManager();
        History history = null;
        try {
            history = entityManager.find(History.class, key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return history;
    }
    
    

    public List<History> findVDHistoryByUserID() {
        EntityManager entityManager = JpaUtils.getEntityManager();
        List<History> histories = null;
        try {
            histories = entityManager.createQuery("SELECT h FROM History h", History.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return histories;
    }
}
