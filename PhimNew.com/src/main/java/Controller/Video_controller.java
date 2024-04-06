package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAO_Favorite;
import DAO.DAO_Video;
import Entity.Users;
import Entity.Video;

@WebServlet("/home/video")
public class Video_controller extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public Video_controller() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        try {
            int videoId = Integer.valueOf(request.getParameter("id"));
            DAO_Video dao_video = new DAO_Video();
            Video video = dao_video.findByID(videoId);
            
            if (video != null) {
                Users user = getCurrentUser(request);
                
                if (user != null) {
                    // Tăng số lượt xem cho video
                    dao_video.increaseViewCount(videoId, user);
                    
                    // Lấy video mới nhất sau khi đã tăng số lượt xem
                    video = dao_video.findByID(videoId);
                    
                    
                    request.setAttribute("v", video);
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
        
        request.getRequestDispatcher("/views/layout/Video.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int videoId = Integer.valueOf(request.getParameter("videoId")) ;
        HttpSession session = request.getSession();
        Users user = (Users)session.getAttribute("user");
        
    	DAO_Favorite dao_Favorite = new DAO_Favorite();
        dao_Favorite.toggleFavorite(user.getId(), videoId);
    }
    
    private Users getCurrentUser(HttpServletRequest request) {
        Users user = (Users) request.getSession().getAttribute("user");
        return user;
    }
}
