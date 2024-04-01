package Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Video")
public class Video {

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
	List<Favorite> favorites;

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


	public Video(int id, String title, String poster, int views, String des, boolean active, String url,
			List<Favorite> favorites) {
		super();
		Id = id;
		this.title = title;
		this.poster = poster;
		this.views = views;
		this.des = des;
		this.active = active;
		this.url = url;
		this.favorites = favorites;
	}

	public List<Favorite> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}

	public Video() {
		super();
	}
	
	
	
	
}
