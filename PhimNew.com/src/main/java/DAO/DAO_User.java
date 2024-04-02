package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import Entity.User;
import Utils.JpaUtils;


public class DAO_User extends DAO<User,String>{

	@Override
	public void insert(User entity) {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction tran = em.getTransaction();
		try {
			tran.begin();
			em.persist(entity);
			tran.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
			throw e;
		}finally {
			em.close();
		}
		
	}

	@Override
	public void update(User entity) {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction tran = em.getTransaction();
		try {
			tran.begin();
			em.merge(entity);
			tran.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
			throw e;
		}finally {
			em.close();
		}
		
	}

	@Override
	public void delete(String key){
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction tran = em.getTransaction();
		
		try {
			tran.begin();
			User user = em.find(User.class,key);
			if(user!=null) {
				em.remove(user);
			}else {
				throw new Exception("This user does not exist!");
			}
			tran.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
		}finally {
			em.close();
		}
	}

	@Override
	public List<User> findAll() {
		EntityManager em = JpaUtils.getEntityManager();
		TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
		return query.getResultList();
	}

	@Override
	public User findByID(String userID) {
		EntityManager em = JpaUtils.getEntityManager();
		String jqpl = "Select o from User o where o.userID = :userID";//userID phải giống với parameter
		TypedQuery<User> query = em.createQuery(jqpl, User.class);
		query.setParameter("userID", userID);
		return query.getSingleResult();
	}

	public User checkLogin(String userID, String password) {
		EntityManager em = JpaUtils.getEntityManager();
		String jqpl = "Select o from User o where o.userID = :userID and o.password = :password";
		TypedQuery<User> query = em.createQuery(jqpl,User.class);
		query.setParameter("userID", userID);
		query.setParameter("password", password);
		
		return query.getSingleResult();
	}
	
	public List<User> findByName(String name){
		EntityManager em = JpaUtils.getEntityManager();
		String jqpl = "Select o from User o where o.fullName like :fullName";
		TypedQuery<User> query = em.createQuery(jqpl, User.class);
		query.setParameter("fullName", "%"+name+"%");
		return query.getResultList();
	}
	
	public List<User> peopleLoveVideos(String vidID){
		EntityManager em = JpaUtils.getEntityManager();
		String jqpl = "Select f.user from Favorite f where f.video.videoID = :getVidID";
		TypedQuery<User> query = em.createQuery(jqpl,User.class);
		query.setParameter("getVidID", vidID);
		return query.getResultList();
	}
}
