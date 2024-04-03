package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAO_User;
import Entity.User;

@WebServlet("/login")
public class loginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public loginControl() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.removeAttribute("user");
		}
		request.getRequestDispatcher("/views/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		DAO_User userDao = new DAO_User();
		User user = userDao.findByID(username);

		if (user != null && user.getPassword().equals(password)) {
			// Lưu thông tin người dùng vào session
			HttpSession session = request.getSession();
			session.setAttribute("user", user);

			response.sendRedirect("/PhimNew/home");
		} else {
			request.setAttribute("message", "Sai tên đăng nhập hoặc mật khẩu!");
			request.getRequestDispatcher("/views/login.jsp").forward(request, response);
		}
	}

}
