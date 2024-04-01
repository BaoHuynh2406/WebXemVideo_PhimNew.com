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


@Entity
@Table(name = "History")
public class Histoty {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	
	@ManyToOne @JoinColumn(name = "UserId")
	User user;
	
	@ManyToOne @JoinColumn(name = "VideoId")
	Video video;
	
	@Temporal(TemporalType.DATE)
	Date HDate = new Date();

	public Histoty(int id, User user, Video video, Date hDate) {
		super();
		Id = id;
		this.user = user;
		this.video = video;
		HDate = hDate;
	}

	public Histoty() {
		super();
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
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

	public Date getHDate() {
		return HDate;
	}

	public void setHDate(Date hDate) {
		HDate = hDate;
	}
	
	
}
