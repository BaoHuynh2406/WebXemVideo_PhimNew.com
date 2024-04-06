package Entity;

import java.io.Serializable;
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

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "History")
public class History implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	
	@ManyToOne @JoinColumn(name = "UserId")
	@JsonIgnore
	Users user;
	
	@ManyToOne @JoinColumn(name = "VideoId")
	@JsonIgnore
	Video video;
	
	@Temporal(TemporalType.DATE)
	Date HDate = new Date();

	public History(int id, Users user, Video video, Date hDate) {
		super();
		Id = id;
		this.user = user;
		this.video = video;
		HDate = hDate;
	}

	public History() {
		super();
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
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
