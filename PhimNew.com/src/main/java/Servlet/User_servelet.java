package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import DAO.DAO_User;
import Entity.UserOnly;
import Entity.Users;

@WebServlet("/admin/all")
public class User_servelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public User_servelet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // Thiết lập chữ tiếng việt
		response.setCharacterEncoding("UTF-8"); // Thiết lập chữ tiếng việt
		
		String url = request.getRequestURL().toString();

		request.setCharacterEncoding("utf-8");
//		if(url.contains("/all")) {
//			
//		}

		findAll(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // Thiết lập chữ tiếng việt
		response.setCharacterEncoding("UTF-8"); // Thiết lập chữ tiếng việt
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			request.setCharacterEncoding("UTF-8"); // Thiết lập chữ tiếng việt
			response.setCharacterEncoding("UTF-8"); // Thiết lập chữ tiếng việt
			DAO_User dao = new DAO_User();
			List<UserOnly> list = dao.getOnly(dao.findAll());

			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.println(new Gson().toJson(list));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
