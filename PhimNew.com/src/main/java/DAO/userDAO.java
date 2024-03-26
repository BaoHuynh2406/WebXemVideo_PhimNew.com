package DAO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import Model.User;

public class userDAO {
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private List<User> ls;
	
	
	
	

	public userDAO() {
		ls=new ArrayList<User>();
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
	
	 public void insert(User u) {
	        ls.add(u);
	    }

	    public User findByUsername(String username) {
	        for (User user : ls) {
	            if (user.getUserName().equals(username)) {
	                return user;
	            }
	        }
	        return null;
	    }

	    public User save(User user) {
	        User existingUser = findByUsername(user.getUserName());
	        if (existingUser != null) {
	            // Update user
	            existingUser.setPassword(user.getPassword());
	            existingUser.setFullName(user.getFullName());
	            existingUser.setGender(user.isGender());
	            // Kiểm tra và cập nhật ngày sinh nếu ngày được gửi từ form là đúng
	            if (user.getDate() != null) {
	                existingUser.setDate(user.getDate());
	            }
	            return existingUser;
	        } else {
	            // Insert new user
	            ls.add(user);
	            return user;
	        }
	    }

	    public boolean delete(String username) {
	        Iterator<User> iterator = ls.iterator();
	        while (iterator.hasNext()) {
	            User user = iterator.next();
	            if (user.getUserName().equals(username)) {
	                iterator.remove();
	                return true;
	            }
	        }
	        return false;
	    }
	    public User edit(User editedUser) {
	        User existingUser = findByUsername(editedUser.getUserName());
	        if (existingUser != null) {
	            // Cập nhật thông tin người dùng
	            existingUser.setPassword(editedUser.getPassword());
	            existingUser.setFullName(editedUser.getFullName());
	            existingUser.setGender(editedUser.isGender());
	            // Kiểm tra và cập nhật ngày sinh nếu ngày được gửi từ form là đúng
	            if (editedUser.getDate() != null) {
	                existingUser.setDate(editedUser.getDate());
	            }
	            return existingUser;
	        } else {
	            return null; 
	        }
	    }
}
