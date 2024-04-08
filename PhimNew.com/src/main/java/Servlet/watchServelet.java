package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import DAO.DAO_Video;
import Entity.Users;
import Entity.Vd;
import Entity.Video;

@WebServlet("/home/video")
public class watchServelet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public watchServelet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        try {
            int videoId = Integer.valueOf(request.getParameter("id"));
            DAO_Video dao_video = new DAO_Video();
            Video v = dao_video.findByID(videoId);
            if (v != null) {
                Users user = getCurrentUser(request);
                
                if (user != null) {
                    // Tăng số lượt xem cho video
                    dao_video.increaseViewCount(videoId, user);
                    
                    // Lấy video mới nhất sau khi đã tăng số lượt xem
                    Vd  video = dao_video.getOnly(v);
                    
                    response.setContentType("application/json");
        			PrintWriter out = response.getWriter();
        			out.println(new Gson().toJson(video));
                } else {
                    throw new ServletException("Không thể xác định người dùng hiện tại");
                }
            } else {
                throw new ServletException("Không tìm thấy video với ID: " + videoId);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", e.getMessage());
        }
        
        
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    
    private Users getCurrentUser(HttpServletRequest request) {
        Users user = (Users) request.getSession().getAttribute("user");
        return user;
    }
}
