package DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import org.hibernate.query.Query;

import Entity.History;
import Entity.Users;
import Entity.VideoOnly;
import Entity.Video;
import Utils.JpaUtils;

public class DAO_Video extends DAO<Video, Integer> {

	@Override
	public void insert(Video entity) {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction tran = em.getTransaction();

		try {
			tran.begin();
			em.persist(entity);
			tran.commit();

		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
		} finally {
			em.close();
		}

	}

	@Override
	public void update(Video entity) {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction tran = em.getTransaction();

		try {
			tran.begin();
			em.merge(entity);
			tran.commit();

		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
		} finally {
			em.close();
		}

	}

	@Override
	public void delete(Integer key) {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction tran = em.getTransaction();

		try {
			tran.begin();
			Video video = em.find(Video.class, key);
			if (video != null) {
				em.remove(video);

			} else {
				throw new Exception("This video does not exist!");
			}
			tran.commit();
		} catch (Exception e) {
			tran.rollback();
			e.printStackTrace();

		} finally {
			em.close();
		}

	}

	@Override
	public List<Video> findAll() {
		EntityManager em = JpaUtils.getEntityManager();
		TypedQuery<Video> query = em.createNamedQuery("Video.findAll", Video.class);
		return query.getResultList();
	}

	@Override
	public Video findByID(Integer key) {
		EntityManager em = JpaUtils.getEntityManager();
		String jqpl = "Select v from Video v where v.Id = :getVidID";// parameter not String key
		TypedQuery<Video> query = em.createQuery(jqpl, Video.class);
		query.setParameter("getVidID", key);
		return query.getSingleResult();
	}

	public List<Video> findByTitle(String title) {
		EntityManager em = JpaUtils.getEntityManager();
		String jqpl = "Select v from Video v where v.title like :getTitle";
		TypedQuery<Video> query = em.createQuery(jqpl, Video.class);
		query.setParameter("getTitle", "%" + title + "%");
		return query.getResultList();
	}

	public List<Video> findFavoriteVidsByUserID(String id) {
		EntityManager em = JpaUtils.getEntityManager();
		String jqpl = "Select f.video from Favorite f where f.user.id = :userID ";
		TypedQuery<Video> query = em.createQuery(jqpl, Video.class);
		query.setParameter("userID", id);
		return query.getResultList();
	}

	public List<Video> findFavoriteVidsByTitle(String title) {
		EntityManager em = JpaUtils.getEntityManager();
		String jqpl = "Select DISTINCT f.video from Favorite f where f.video.title like :getTitle";
		TypedQuery<Video> query = em.createQuery(jqpl, Video.class);
		query.setParameter("getTitle", "%" + title + "%");
		return query.getResultList();
	}

	public List<Video> favoriteNotFavorite(boolean loveOrNot) {
		EntityManager em = JpaUtils.getEntityManager();
		String jqpl = "Select v from Video v where v.favorites IS EMPTY";
		if (loveOrNot) {
			jqpl = "Select v from Video v where v.favorites IS NOT EMPTY";
		}
		TypedQuery<Video> query = em.createQuery(jqpl, Video.class);
		return query.getResultList();
	}

	public List<Video> findVideoActive(boolean isActive) {
		EntityManager em = JpaUtils.getEntityManager();
		String jqpl = "Select v from Video v where v.active =:isActive";
		TypedQuery<Video> query = em.createQuery(jqpl, Video.class);
		query.setParameter("isActive", isActive);
		return query.getResultList();
	}

	// B�i 3
	public List<Video> findByUser(String id) {
		EntityManager em = JpaUtils.getEntityManager();
		TypedQuery<Video> query = em.createNamedQuery("Video.findByUser", Video.class);
		query.setParameter("getUserID", id);
		return query.getResultList();
	}

	public List<Video> findVideoByTitle(String vidTitle) {
		EntityManager em = JpaUtils.getEntityManager();
		TypedQuery<Video> query = em.createNamedQuery("Video.findVideoByTitles", Video.class);
		query.setParameter("getVideoTitle", vidTitle);
		return query.getResultList();
	}

	public List<Video> findVideoFromRange(Date dateA, Date dateB) {
		EntityManager em = JpaUtils.getEntityManager();
		TypedQuery<Video> query = em.createNamedQuery("Video.favoriteVidsInRange", Video.class);
		query.setParameter("getMinDate", dateA);
		query.setParameter("getMaxDate", dateB);
		return query.getResultList();
	}

	public List<Video> findInMonths(String[] months) {
		EntityManager em = JpaUtils.getEntityManager();
		String sql = "Select DISTINCT f.video from Favorite f where month(f.likeDate) in (:months)";
		List<Integer> listMonth = new ArrayList<Integer>();
		for (String month : months) {
			listMonth.add(Integer.parseInt(month));
		}
		TypedQuery<Video> query = em.createQuery(sql, Video.class);
		query.setParameter("months", listMonth);
		return query.getResultList();
	}

	// Bai 4
	@SuppressWarnings("unchecked")
	public List<Video> rand5Vids() {
		EntityManager em = JpaUtils.getEntityManager();
		javax.persistence.Query query = em.createNamedQuery("Report.random5");
		return query.getResultList();
	}

	public void increaseViewCount(Integer videoId, Users user) {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction tran = em.getTransaction();

		try {
			tran.begin();
			Video video = em.find(Video.class, videoId);
			if (video != null) {
				int currentViews = video.getViews();
				video.setViews(currentViews + 1);
				em.merge(video);
				tran.commit();

				// Gọi trực tiếp phương thức thêm vào lịch sử
				// tìm id
				Integer videoID = video.getId();

				// thêm vào bảng History
				DAO_History daoHistory = new DAO_History();
				History history = new History();
				history.setUser(user);
				history.setVideo(video);
				daoHistory.insert(history);

			} else {
				throw new Exception("Video not found!");
			}
		} catch (Exception e) {
			if (tran != null && tran.isActive()) {
				tran.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	public List<VideoOnly> getOnly(List<Video> list) {
		List<VideoOnly> listReturn = new ArrayList();
		for (Video v : list) {
			listReturn.add(
					new VideoOnly(v.getId(), v.getTitle(), v.getPoster(), v.getViews(), v.getDes(), v.isActive(), v.getUrl()));
		}

		return listReturn;
	}

	public VideoOnly getOnly(Video v) {
		VideoOnly o = new VideoOnly(v.getId(), v.getTitle(), v.getPoster(), v.getViews(), v.getDes(), v.isActive(), v.getUrl());
		return o;
	}

//	@SuppressWarnings("unchecked")
//	public List<TemporaryClass> reportFavoriteByYear(Integer year){
//		EntityManager em = JpaUtils.getEntityManager();
//		StoredProcedureQuery query = em.createStoredProcedureQuery("sp_FavoriteByYear",TemporaryClass.class);
//		query.registerStoredProcedureParameter("year", Integer.class, ParameterMode.IN);
//		query.setParameter("year", year);
//		return query.getResultList();
//	}

}
