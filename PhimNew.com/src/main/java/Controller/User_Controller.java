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

import DAO.DAO_User;
import Entity.Users;

@WebServlet({ "/user/index", "/user/create", "/user/update", "/user/delete", "/user/reset", "/user/edit/*",
		"/user/delete/*", })
public class User_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public User_Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = request.getRequestURL().toString();

		request.setCharacterEncoding("utf-8");

		Users user = null;

		if (url.contains("delete")) {
			DAO_User dao = new DAO_User();
			if (request.getParameter("id") != null) {
				dao.delete(request.getParameter("id"));
				request.setAttribute("message", "Delete success!");
			}
			// xóa rỗng các ô texbox
			user = new Users();
			request.setAttribute("user", user);
		}

		else if (url.contains("edit")) {
			DAO_User dao = new DAO_User();
			if (request.getParameter("id") != null)
				user = dao.findByID(request.getParameter("id"));
			request.setAttribute("user", user);
		}

		findAll(request, response);
		request.getRequestDispatcher("/views/user.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = request.getRequestURL().toString();
		request.setCharacterEncoding("utf-8");
		Users user = new Users();
		if (url.contains("create")) {
			create(request, response);
		} else if (url.contains("update")) {
			update(request, response);
		} else if (url.contains("delete")) {
			delete(request, response);
		} else if (url.contains("reset")) {
			request.setAttribute("user", new Users());
		}
		findAll(request, response);
		request.getRequestDispatcher("/views/user.jsp").forward(request, response);
	}

	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Users user = new Users();
			BeanUtils.populate(user, request.getParameterMap());
			DAO_User dao = new DAO_User();
			dao.insert(user);
			request.setAttribute("message", "Create success!");
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
			Users user = new Users();
			BeanUtils.populate(user, request.getParameterMap());
			DAO_User dao = new DAO_User();
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
			Users user = new Users();
			BeanUtils.populate(user, request.getParameterMap());
			DAO_User dao = new DAO_User();
			if (user.getId() != null)
				dao.delete(user.getId());
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
			DAO_User dao = new DAO_User();
			List<Users> list = dao.findAll();
			request.setAttribute("users", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}

}
