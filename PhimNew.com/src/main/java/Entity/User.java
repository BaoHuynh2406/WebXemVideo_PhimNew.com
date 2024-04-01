package Entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="Users")
public class User {
	@Id
	@Column(name = "Id")
	private String id;
	
	@Column(name = "Password")
	private String password;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "Gender")
	private boolean gender;
	
	@Column(name = "Fullname")
	private String fullName;
	
	@Column(name = "Date")
	private Date date;
	
	@Column(name = "Admin")
	private boolean admin;
	
	@OneToMany(mappedBy = "user")
	List<Favorite> favorite;

	public User() {
		super();
	}


	


	public User(String id, String password, String email, boolean gender, String fullName, Date date, boolean admin,
			List<Favorite> favorite) {
		super();
		this.id = id;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.fullName = fullName;
		this.date = date;
		this.admin = admin;
		this.favorite = favorite;
	}





	public List<Favorite> getFavorite() {
		return favorite;
	}





	public void setFavorite(List<Favorite> favorite) {
		this.favorite = favorite;
	}





	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public boolean isGender() {
		return gender;
	}


	public void setGender(boolean gender) {
		this.gender = gender;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public boolean isAdmin() {
		return admin;
	}


	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	
	
}
