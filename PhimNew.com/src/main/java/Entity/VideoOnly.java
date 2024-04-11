package Entity;

import javax.persistence.Column;

public class VideoOnly {
private int Id;
	
	
	private String title;
	

	private String poster;
	

	private int views;
	

	private String des;
	

	private boolean active;
	

	private String url;


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


	public VideoOnly() {
		super();
	}


	public VideoOnly(int id, String title, String poster, int views, String des, boolean active, String url) {
		super();
		Id = id;
		this.title = title;
		this.poster = poster;
		this.views = views;
		this.des = des;
		this.active = active;
		this.url = url;
	}
	
	
}
