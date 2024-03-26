package Model;

public class Video_item {
		private String title;
		private String des;
		private String photo;
		private int views;
		private int likes;
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
		public Video_item(String title, String des, String photo, int views, int likes) {
			super();
			this.title = title;
			this.des = des;
			this.photo = photo;
			this.views = views;
			this.likes = likes;
		}
		
		
}
