package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import Entity.UserOnly;
import Entity.Users;
import Utils.JpaUtils;


public class DAO_User extends DAO<Users,String>{

	@Override
	public void insert(Users entity) {
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
	public void update(Users entity) {
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
			Users user = em.find(Users.class,key);
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
	public List<Users> findAll() {
		EntityManager em = JpaUtils.getEntityManager();
		TypedQuery<Users> query = em.createNamedQuery("Users.findAll", Users.class);
		return query.getResultList();
	}

	@Override
	public Users findByID(String userID) {
		try {
			EntityManager em = JpaUtils.getEntityManager();
			String jqpl = "Select o from Users o where o.id = :userID";// userID phải giống với parameter
			TypedQuery<Users> query = em.createQuery(jqpl, Users.class);
			query.setParameter("userID", userID);
			return query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	public Users checkLogin(String userID, String password) {
		try {
			EntityManager em = JpaUtils.getEntityManager();
			String jqpl = "Select o from Users o where o.id = :userID and o.password = :password";
			TypedQuery<Users> query = em.createQuery(jqpl,Users.class);
			query.setParameter("userID", userID);
			query.setParameter("password", password);
			
			return query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
		
	}
	
	public List<Users> findByName(String name){
		EntityManager em = JpaUtils.getEntityManager();
		String jqpl = "Select o from Users o where o.fullName like :fullName";
		TypedQuery<Users> query = em.createQuery(jqpl, Users.class);
		query.setParameter("fullName", "%"+name+"%");
		return query.getResultList();
	}
	
	public List<Users> peopleLoveVideos(String vidID){
		EntityManager em = JpaUtils.getEntityManager();
		String jqpl = "Select f.user from Favorite f where f.video.id = :getVidID";
		TypedQuery<Users> query = em.createQuery(jqpl,Users.class);
		query.setParameter("getVidID", vidID);
		return query.getResultList();
	}
	
	public List<UserOnly> getOnly(List<Users> list) {
		List<UserOnly> listReturn = new ArrayList<UserOnly>();
		for (Users v : list) {
			listReturn.add(
					new UserOnly(v.getId(), v.getPassword(), v.getEmail(), v.isGender(), v.getFullName(), v.getBirthday(), v.isAdmin()));
		}

		return listReturn;
	}

	public UserOnly getOnly(Users v) {
		UserOnly o = new UserOnly(v.getId(), v.getPassword(), v.getEmail(), v.isGender(), v.getFullName(), v.getBirthday(), v.isAdmin());
		return o;
	}
}
