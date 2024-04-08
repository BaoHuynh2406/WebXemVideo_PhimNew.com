package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import Entity.History;
import Entity.Video;
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

<<<<<<< Updated upstream
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

	public List<Video> findVDHistoryByUserID(String id) {
		EntityManager entityManager = JpaUtils.getEntityManager();
		try {
			EntityManager em = JpaUtils.getEntityManager();
			String jpql = "SELECT DISTINCT h.video FROM History h WHERE h.user.id = :userID";
			TypedQuery<Video> query = em.createQuery(jpql, Video.class);
			query.setParameter("userID", id);
			List<Video> videos = query.getResultList();
			videos.sort((v1, v2) -> v2.getHistories().get(0).getHDate().compareTo(v1.getHistories().get(0).getHDate()));
			return videos;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
		return null;
	}

=======
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
>>>>>>> Stashed changes
}
