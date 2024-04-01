package Entity;

import java.util.Date;

import javax.persistence.Column;
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
@Table(name="Share")
public class Share {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	
	@ManyToOne @JoinColumn(name = "UserId")
	User user;
	
	@ManyToOne @JoinColumn(name = "VideoId")
	Video video;
	
	@Column(name = "Emails")
	private String Emails;
	
	@Temporal(TemporalType.DATE)
	private Date ShareDate = new Date();

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

	public String getEmails() {
		return Emails;
	}

	public void setEmails(String emails) {
		Emails = emails;
	}

	public Date getShareDate() {
		return ShareDate;
	}

	public void setShareDate(Date shareDate) {
		ShareDate = shareDate;
	}

	public Share(int id, User user, Video video, String emails, Date shareDate) {
		super();
		Id = id;
		this.user = user;
		this.video = video;
		Emails = emails;
		ShareDate = shareDate;
	}

	public Share() {
		super();
	}
	
	


	
	
}
