package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.userDAO;
import DAO.videoDAO;
import Entity.User;

@WebServlet({ "/home", "/home/logout" })
public class HomePageControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomePageControl() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURL().toString();

		if (url.contains("/home/logout")) {
			HttpSession session = request.getSession(false);
			if (session != null) {
				// Xóa thông tin người dùng khỏi session
				session.removeAttribute("user");
			}
			response.sendRedirect("/PhimNew/login");
			return;
		}

		request.setCharacterEncoding("UTF-8"); // Thiết lập chữ tiếng việt
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");
		if (user == null) {
			response.sendRedirect("/PhimNew/login");
			return;
		}
		request.setAttribute("user", user);
		videoDAO dao = new videoDAO();
		request.setAttribute("LIST_VIDEO", dao.createData());
		request.getRequestDispatcher("/views/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
