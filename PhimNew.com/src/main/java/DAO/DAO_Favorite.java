package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Entity.Favorite;
import Entity.Users;
import Entity.Video;
import Utils.JpaUtils;

public class DAO_Favorite extends DAO<Favorite, Long> {
	@Override
	public void insert(Favorite entity) {
		EntityManager em = JpaUtils.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	@Override
	public void delete(Long key) {
		EntityManager em = JpaUtils.getEntityManager();
		try {
			em.getTransaction().begin();
			Favorite favorite = em.find(Favorite.class, key);
			em.remove(favorite);
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	@Override
	public List<Favorite> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Users> videoLikedByUsers(String videoID) {
		EntityManager em = JpaUtils.getEntityManager();
		String jqpl = "Select f.user From Favorite f where f.video.videoID = :videoID";
		TypedQuery<Users> query = em.createQuery(jqpl, Users.class);
		query.setParameter("videoID", videoID);
		return query.getResultList();
	}

	public List<Integer> getYearForFavoriteVids() {
		EntityManager em = JpaUtils.getEntityManager();
		TypedQuery<Integer> query = em.createNamedQuery("GetYear.FavoriteVideos", Integer.class);
		return query.getResultList();
	}
	// yêu thích
	public void toggleFavorite(String userId, int videoId) {

		System.out.println(userId + "==" + videoId);
		EntityManager em = JpaUtils.getEntityManager();
		try {
			em.getTransaction().begin();
			TypedQuery<Favorite> query = em.createQuery(
					"SELECT f FROM Favorite f WHERE f.user.id = :userId AND f.video.id = :videoId", Favorite.class);

			query.setParameter("userId", userId);
			query.setParameter("videoId", videoId);
			List<Favorite> results = query.getResultList();
			if (!results.isEmpty()) {
				// Nếu đã có trong danh sách yêu thích, xóa khỏi danh sách
				delete(results.get(0).getId());
			} else {
				// Nếu chưa có trong danh sách yêu thích, thêm vào danh sách
				Users user = em.find(Users.class, userId);
				Video video = em.find(Video.class, videoId);
				if (user != null && video != null) {
					Favorite favorite = new Favorite();
					favorite.setUser(user);
					favorite.setVideo(video);
					insert(favorite);
				}
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
			System.out.println("Lỗi DAO" + e.getMessage());
		} finally {
			em.close();
		}
	}

	@Override
	public void update(Favorite entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Favorite findByID(Long key) {
		// TODO Auto-generated method stub
		return null;
	}

	public int likeNum(int videoID) {
		EntityManager em = JpaUtils.getEntityManager();
		try {
			TypedQuery<Long> query = em.createQuery("SELECT COUNT(f) FROM Favorite f WHERE f.video.id = :videoID",
					Long.class);
			query.setParameter("videoID", videoID);
			Long likeCount = query.getSingleResult();
			return likeCount.intValue();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Lỗi DAO: " + e.getMessage());
			return 0; // Trả về 0 nếu có lỗi xảy ra
		} finally {
			em.close();
		}
	}

	
	//Kiễm tra user có yêu thích video đó không
	public boolean checkLike(String userId, int videoId) {
	    EntityManager em = JpaUtils.getEntityManager();
	    try {
	        TypedQuery<Long> query = em.createQuery(
	                "SELECT COUNT(f.id) FROM Favorite f WHERE f.user.id = :userId AND f.video.id = :videoId",
	                Long.class);
	        query.setParameter("userId", userId);
	        query.setParameter("videoId", videoId);
	        Long count = query.getSingleResult();
	        return count > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    } finally {
	        em.close();
	    }
	}


}
