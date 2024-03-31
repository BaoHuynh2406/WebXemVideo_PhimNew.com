package Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Share")
public class Share {

	@Id
	private int Id;
	
	private String UserId;
	
	private int VideoId;
	
	private String Emails;
	
	private Date ShareDate;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public int getVideoId() {
		return VideoId;
	}

	public void setVideoId(int videoId) {
		VideoId = videoId;
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

	public Share(int id, String userId, int videoId, String emails, Date shareDate) {
		super();
		Id = id;
		UserId = userId;
		VideoId = videoId;
		Emails = emails;
		ShareDate = shareDate;
	}

	public Share() {
		super();
	}
	
	
}
