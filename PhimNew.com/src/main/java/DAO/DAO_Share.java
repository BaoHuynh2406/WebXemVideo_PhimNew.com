package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import Entity.Share;
import Utils.JpaUtils;

public class DAO_Share extends DAO<Share, Integer> {

    @Override
    public void insert(Share entity) {
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void update(Share entity) {
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
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
            Share share = entityManager.find(Share.class, key);
            if (share != null) {
                entityManager.remove(share);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Share> findAll() {
        EntityManager entityManager = JpaUtils.getEntityManager();
        Query query = entityManager.createQuery("SELECT s FROM Share s");
        List<Share> shares = query.getResultList();
        entityManager.close();
        return shares;
    }

    @Override
    public Share findByID(Integer key) {
        EntityManager entityManager = JpaUtils.getEntityManager();
        Share share = entityManager.find(Share.class, key);
        entityManager.close();
        return share;
    }
}
