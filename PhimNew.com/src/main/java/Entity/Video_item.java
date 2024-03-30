package Entity;

public class Video_item {
		private int id;
		private String title;
		private String des;
		private String photo, url;
		private int views;
		private int likes;
		private boolean active;
		
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getDes() {
			return des;
		}
		public void setDes(String des) {
			this.des = des;
		}
		public String getPhoto() {
			return photo;
		}
		public void setPhoto(String photo) {
			this.photo = photo;
		}
		public int getViews() {
			return views;
		}
		public void setViews(int views) {
			this.views = views;
		}
		public int getLikes() {
			return likes;
		}
		public void setLikes(int likes) {
			this.likes = likes;
		}
		
		
		
		public Video_item(int id, String title, String des, String photo, String url, int views, int likes,
				boolean active) {
			super();
			this.id = id;
			this.title = title;
			this.des = des;
			this.photo = photo;
			this.url = url;
			this.views = views;
			this.likes = likes;
			this.active = active;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public boolean isActive() {
			return active;
		}
		public void setActive(boolean active) {
			this.active = active;
		}
		public Video_item(String title, String des, String photo, String url, int views, int likes) {
			super();
			this.title = title;
			this.des = des;
			this.photo = photo;
			this.url = url;
			this.views = views;
			this.likes = likes;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
	
		
		
}
