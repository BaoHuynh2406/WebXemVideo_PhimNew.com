package Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "Favorite", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"VideoId", "UserId"})
})
public class Favorite {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	 Long Id;
	
	@ManyToOne @JoinColumn(name = "UserId")
	User user;
	
	@ManyToOne @JoinColumn(name = "VideoId")
	Video video;
	
	@Temporal(TemporalType.DATE)
	Date likeDate = new Date();

	public Favorite(Long id, User user, Video video, Date likeDate) {
		super();
		Id = id;
		this.user = user;
		this.video = video;
		this.likeDate = likeDate;
	}

	public Favorite() {
		super();
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public Date getLikeDate() {
		return likeDate;
	}

	public void setLikeDate(Date likeDate) {
		this.likeDate = likeDate;
	}
	
	
}
