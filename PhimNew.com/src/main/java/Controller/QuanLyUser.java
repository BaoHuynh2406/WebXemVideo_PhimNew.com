package Controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import DAO.userDAO;
import Entity.User;

@WebServlet({ 
	"/user/index",
	"/user/create", 
	"/user/update", 
	"/user/delete", 
	"/user/reset", 
	"/user/edit/*",
	"/user/delete/*", })
public class QuanLyUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public QuanLyUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = request.getRequestURL().toString();

		request.setCharacterEncoding("utf-8");

		User user = null;

		if (url.contains("delete")) {
			userDAO dao = new userDAO();
			if (request.getParameter("id") != null) {
				dao.remove(request.getParameter("id"));
				request.setAttribute("message", "Delete success!");
			}
			// xóa rỗng các ô texbox
			user = new User();
			request.setAttribute("user", user);
		}

		else if (url.contains("edit")) {
			userDAO dao = new userDAO();
			if (request.getParameter("id") != null)
				user = dao.findById(request.getParameter("id"));
			request.setAttribute("user", user);
		}

		findAll(request, response);
		request.getRequestDispatcher("/views/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = request.getRequestURL().toString();
		request.setCharacterEncoding("utf-8");
		User user = new User();
		if (url.contains("create")) {
			create(request, response);
		} else if (url.contains("update")) {
			update(request, response);
		} else if (url.contains("delete")) {
			delete(request, response);
		} else if (url.contains("reset")) {
			request.setAttribute("user", new User());
		}
		findAll(request, response);
		request.getRequestDispatcher("/views/user.jsp").forward(request, response);
	}

	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			User user = new User();
			BeanUtils.populate(user, request.getParameterMap());
			userDAO dao = new userDAO();
			dao.create(user);
			request.setAttribute("message", "Create success!");
			response.sendRedirect(request.getContextPath() + "/login");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			User user = new User();
			BeanUtils.populate(user, request.getParameterMap());
			userDAO dao = new userDAO();
			dao.update(user);
			request.setAttribute("message", "Update success!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			User user = new User();
			BeanUtils.populate(user, request.getParameterMap());
			userDAO dao = new userDAO();
			if (user.getId() != null)
				dao.remove(user.getId());
			request.setAttribute("message", "Delete success!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	protected void findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			userDAO dao = new userDAO();
			List<User> list = dao.findAll();
			request.setAttribute("users", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}

}
