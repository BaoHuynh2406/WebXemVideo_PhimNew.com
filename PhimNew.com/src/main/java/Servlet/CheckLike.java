package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import DAO.DAO_Favorite;
import Entity.Users;


@WebServlet("/home/watch/CheckLike")
public class CheckLike extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckLike() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   int videoId = Integer.valueOf(request.getParameter("id")) ;
		   System.out.println(videoId + " LIKE OF");
	        HttpSession session = request.getSession();
	        Users user = (Users)session.getAttribute("user");
	        
	        DAO_Favorite dao_Favorite = new DAO_Favorite();
	        boolean isLiked = dao_Favorite.checkLike(user.getId(), videoId);
	        int likeNum = dao_Favorite.likeNum(videoId); 

	        // Tạo JSON object chứa kết quả
	        JsonObject jsonResponse = new JsonObject();
	        jsonResponse.addProperty("isLiked", isLiked);
	        jsonResponse.addProperty("likeNum", likeNum);
	        
	        System.out.println(user.getId() + " LIKE VIDEO " +videoId + " - " + isLiked + likeNum);
	        // Trả về dữ liệu JSON
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        PrintWriter out = response.getWriter();
	        out.print(jsonResponse.toString());
	        out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
