package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.userDAO;
import Entity.User;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class loginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public loginControl() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
        String password = request.getParameter("password");

        userDAO userDao = new userDAO();
        User user = userDao.findById(username);

        if (user != null && user.getPassword().equals(password)) {
            // Đăng nhập thành công
            request.getRequestDispatcher("/home").forward(request, response);
        } else {
            // Đăng nhập không thành công
            request.setAttribute("message", "Sai tên đăng nhập hoặc mật khẩu!");
            request.getRequestDispatcher("/views/login.jsp").forward(request, response);
        }
	}
}
