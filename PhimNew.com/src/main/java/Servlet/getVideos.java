package Servlet;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import DAO.DAO_History;
import DAO.DAO_Video;
import Entity.Users;
import Entity.Vd;
import Entity.Video;

@WebServlet("/VideoLoad")
public class getVideos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public getVideos() {
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
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");
		// Lấy giá trị của tham số tab từ yêu cầu
		String tab = request.getParameter("tab");
		
		DAO_Video dao = new DAO_Video();
		DAO_History daoH = new DAO_History();
		// Tạo danh sách các video tương ứng với tab
		List<Vd> videos = new ArrayList();
		try {
			if ("made_for_you".equals(tab)) {
				videos = dao.getOnly(dao.findVideoActive(true));
				System.out.println(tab);
			} else if ("yeu_thich".equals(tab)) {
				videos = dao.getOnly(dao.findFavoriteVidsByUserID(user.getId()));
				System.out.println(tab);
			} else if ("da_xem".equals(tab)) {
				videos = dao.getOnly(daoH.findVDHistoryByUserID(user.getId()));
				System.out.println(tab);
			}
			
			// Chuyển danh sách video thành JSON và gửi về client
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.println(new Gson().toJson(videos));

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Lỗi: " + e.getMessage());
		}

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
