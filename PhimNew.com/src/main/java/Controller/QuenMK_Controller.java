package Controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAO_User;
import Entity.Users;
import Utils.senemail;

/**
 * Servlet implementation class QuenMK_Controller
 */
@WebServlet("/QuenMK")
public class QuenMK_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public QuenMK_Controller() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		request.getRequestDispatcher("Admin/forgot-password.html").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		String email = request.getParameter("email");
		DAO_User dao_user = new DAO_User();
		Users user = new Users();
		user = dao_user.findByID(userName);
		Random random = new Random();
		String randomNumber = "";
        for (int i = 0; i < 6; i++) {
            int digit = random.nextInt(10); // Tạo số ngẫu nhiên từ 0 đến 9
            randomNumber += digit; // Ghép số vào chuỗi
        }
		if(user!=null) {
			if(user.getEmail().equals(email)) {
				senemail.guimail(user.getEmail(), "đây là mã khôi phục của bạn : "+randomNumber);
				//chuyển sang form khác
				return ;
			}else {
				request.setAttribute("mesage", "lỗi !!!");
			}
		}else {
			request.setAttribute("mesage", "lỗi !!!");
		}
		request.setCharacterEncoding("utf-8");
		request.getRequestDispatcher("Admin/forgot-password.html").forward(request, response);
		
		
	}

}
