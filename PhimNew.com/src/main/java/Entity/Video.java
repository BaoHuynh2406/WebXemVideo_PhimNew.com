package Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;




@Entity
@Table(name = "Video")
@NamedQueries({
	@NamedQuery(name="Video.findAll", 
			query="SELECT v FROM Video v"),
	@NamedQuery(name="Video.findByUser",
	query="Select f.video from Favorite f where f.user.id = :getUserID"),
	@NamedQuery(name="Video.findVideoByTitles",
			query="Select DISTINCT f.video from Favorite f where f.video.title like :getVideoTitle"),
	@NamedQuery(name="Video.favoriteVidsInRange",
			query="Select DISTINCT f.video from Favorite f where f.likeDate between :getMinDate and :getMaxDate"),
//	@NamedQuery(name="Video.findByMonths",
//			query="Select DISTINCT f.video from Favorite f where month(f.likeDate) in ( :months )")
})
@NamedNativeQueries({
	@NamedNativeQuery(name = "Report.random5", query = "Select top 5 * from Videos Order By newid()",resultClass = Video.class),
})
public class Video implements Serializable {

	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "poster")
	private String poster;
	
	@Column(name = "views")
	private int views;
	
	@Column(name = "des")
	private String des;
	
	@Column(name = "active")
	private boolean active;
	
	@Column(name = "url")
	private String url;
	

	@OneToMany(mappedBy = "video")
	@JsonIgnoreProperties
	List<Favorite> favorites;
	 
	 
	@OneToMany(mappedBy = "video")
	@JsonIgnoreProperties
	List<History> Histories;

	public Video(int id, String title, String poster, int views, String des, boolean active, String url,
			List<Favorite> favorites, List<History> histories) {
		super();
		Id = id;
		this.title = title;
		this.poster = poster;
		this.views = views;
		this.des = des;
		this.active = active;
		this.url = url;
		this.favorites = favorites;
		Histories = histories;
	}

	public Video() {
		super();
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Favorite> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}

	public List<History> getHistories() {
		return Histories;
	}

	public void setHistories(List<History> histories) {
		Histories = histories;
	}

	
	
	
	
	
}
