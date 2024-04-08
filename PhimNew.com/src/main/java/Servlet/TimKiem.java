package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import DAO.DAO_Video;
import Entity.Vd;
import Entity.Video;


@WebServlet("/home/timkiem")
public class TimKiem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimKiem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8"); // Thiết lập chữ tiếng việt
		response.setCharacterEncoding("UTF-8"); // Thiết lập chữ tiếng việt
		
		
		
		try {
			String NDtimkiem = request.getParameter("key");
			System.out.println(NDtimkiem);
		    DAO_Video daovideo = new DAO_Video();
		    List<Vd> videos = new ArrayList();
		    videos =daovideo.getOnly( daovideo.findByTitle(NDtimkiem));
		    System.out.println(videos.get(0).getTitle());
		    
		    response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.println(new Gson().toJson(videos));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
