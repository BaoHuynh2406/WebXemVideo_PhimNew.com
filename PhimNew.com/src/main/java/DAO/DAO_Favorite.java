package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Entity.Favorite;
import Entity.Users;
import Utils.JpaUtils;


public class DAO_Favorite extends DAO<Favorite, Integer>{
	@Override
	public void insert(Favorite entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Favorite entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Favorite> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Favorite findByID(Integer key) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Users> videoLikedByUsers(String videoID){
		EntityManager em = JpaUtils.getEntityManager();
		String jqpl = "Select f.user From Favorite f where f.video.videoID = :videoID";
		TypedQuery<Users> query = em.createQuery(jqpl,Users.class);
		query.setParameter("videoID", videoID);
		return query.getResultList();
	}
	
	public List<Integer> getYearForFavoriteVids(){
		EntityManager em = JpaUtils.getEntityManager();
		TypedQuery<Integer> query = em.createNamedQuery("GetYear.FavoriteVideos", Integer.class);
		return query.getResultList();
	}

}
