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
import DAO.DAO_Video;
import Entity.UserOnly;
import Entity.Users;
import Entity.VideoOnly;

@WebServlet({"/admin/allUser", "/admin/allVideo"})
public class admin_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public admin_servlet() {
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
		if(url.contains("allUser")) {
			findAllUser(request, response);
		}
		if(url.contains("allVideo")) {
			findAllVideo(request, response);
		}

		
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

	protected void findAllUser(HttpServletRequest request, HttpServletResponse response)
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
	
	protected void findAllVideo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			request.setCharacterEncoding("UTF-8"); // Thiết lập chữ tiếng việt
			response.setCharacterEncoding("UTF-8"); // Thiết lập chữ tiếng việt
			DAO_Video dao = new DAO_Video();
			List<VideoOnly> list = dao.getOnly(dao.findAll());

			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.println(new Gson().toJson(list));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
