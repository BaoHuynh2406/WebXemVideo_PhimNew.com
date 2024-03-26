package DAO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Model.User;

public class userDAO {
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	List<User> ls = new ArrayList<User>();
	
	
	
	
	public userDAO() {
		ls = data();
	}

	public List<User> data()  {
		try {
			ls.add(new User("SV0001", "baohuynh123", "Huỳnh Bảo", "baobao@gmail.com", true,
					dateFormat.parse("24/06/2004")));

			ls.add(new User("SV0002", "baohuynh123", "Le Nam", "baobao@gmail.com", true,
					dateFormat.parse("24/06/2001")));

			ls.add(new User("SV0003", "baohuynh123", "Văn Dũng", "baobao@gmail.com", false,
					dateFormat.parse("24/06/2003")));
			return ls;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}

	public List<User> getAll(){
		return ls;
	}
	
	public User findByUsername(String u) {
		System.out.println("loading");
		for (User user : ls) {
			if(user.getUserName().equalsIgnoreCase(u)) {
				System.err.println(user);
				return user;
			}
		}
		System.err.println("Not found");
		return null;
	}
}
