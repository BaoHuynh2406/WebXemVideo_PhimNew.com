package Utils;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.userDAO;
import DAO.videoDAO;
import Entity.User;

public class Security {
	public static User isLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Cookie[] cookies = request.getCookies();
		User u;
		// Xem có cookie không
		if (cookies != null) {
			for (Cookie cookie : cookies) {

//	            	Nếu có cookie
				if (cookie.getName().equals("username")) {
					String username = cookie.getValue();
					u = new userDAO().findById(username);
//	                    Cookie đúng hay không
//	                    Đúng
					if (u != null)
						return u;
//	                    Sai
					break;
				}
			}

		}
//			Sai thì chuyển hướng
		response.sendRedirect("/PhimNew/login");
		return null;
	}
}
