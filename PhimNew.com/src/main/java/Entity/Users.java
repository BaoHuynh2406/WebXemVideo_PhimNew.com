package Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="Users")
@NamedQuery(name="Users.findAll", query="SELECT u FROM Users u")
public class Users implements Serializable {
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
	
	@Temporal(TemporalType.DATE)
	Date birthday = new Date();
	
	@Column(name = "Admin")
	private boolean admin;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	List<Favorite> favorite;

	@OneToMany(mappedBy = "user")
	@JsonIgnore
	List<History> Histories;

	public List<Favorite> getFavorite() {
		return favorite;
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public List<History> getHistories() {
		return Histories;
	}

	public void setHistories(List<History> histories) {
		Histories = histories;
	}

	public void setFavorite(List<Favorite> favorite) {
		this.favorite = favorite;
	}

	public Users(String id, String password, String email, boolean gender, String fullName, Date birthday, boolean admin,
			List<Favorite> favorite, List<History> histories) {
		super();
		this.id = id;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.fullName = fullName;
		this.birthday = birthday;
		this.admin = admin;
		this.favorite = favorite;
		Histories = histories;
	}

	public Users() {
		super();
	}


	
	
}
