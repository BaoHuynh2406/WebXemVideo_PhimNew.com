package DAO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Entity.User;

public class userDAO {
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private EntityManager em = Utils.JpaUtils.getEntityManager();

	
//	Them nhan vien moi
	public User create(User entity) {
		try {
			em.getTransaction().begin();

			em.persist(entity);// them

			em.getTransaction().commit();
			return entity;
		} catch (Exception e) {

			em.getTransaction().rollback();
			throw new RuntimeException(e);
			// TODO: handle exception
		}
	}

	
//	Cap nhat nhan vien
	public User update(User entity) {
		try {
			em.getTransaction().begin();

			em.merge(entity); // ham sua
			em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
			// TODO: handle exception
		}
	}

	
//	Xoa nhan vien
	public User remove(String id) {
		try {
			em.getTransaction().begin();
			User entity = this.findById(id);

			em.remove(entity);
			em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
			// TODO: handle exception
		}
	}

	
//	Tim nhan vien theo ID
	public User findById(String id) {
		return em.find(User.class, id);
	}

//	Tim Nhan vien theo rolde
	public List<User> findByRole(boolean role) {
		String jpql = "Select o from User o where o.admin=:role1";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		query.setParameter("role1", role);
		return query.getResultList();
	}

	public List<User> findByKeyWord(String keyword) {
		String jpql = "Select o from User o where o.fullname like ?0";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		query.setParameter(0, keyword);
		return query.getResultList();
	}

	public User findOne(String username, String password) {
		String jpql = "Select o from User o where o.id=:id and o.password=:pass";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		query.setParameter("id", username);
		query.setParameter("pass", password);
		return query.getSingleResult();
	}

	public User findByEmail(String email) {
		String jpql = "Select o from User o where o.email=:email";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		query.setParameter("email", email);
		return query.getSingleResult();
	}

	public List<User> findPage(int page, int size) {
		String jpql = "Select o from User o";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		query.setFirstResult(page * size);
		query.setMaxResults(size);
		return query.getResultList();
	}

	// lấy hết usser lên
	public List<User> findAll() {
		String jpql = "Select o from User o";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		return query.getResultList();
	}
}
