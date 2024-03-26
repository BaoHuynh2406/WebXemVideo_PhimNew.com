package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.videoDAO;

@WebServlet("/home")
public class HomePageControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public HomePageControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // Thiết lập chữ tiếng việt
		videoDAO dao = new videoDAO();
		request.setAttribute("LIST_VIDEO", dao.createData());
		
		request.getRequestDispatcher("/views/index.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
