package Controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import DAO.DAO_User;
import Entity.User;




@WebServlet("/SignUp")
public class DangKyPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DangKyPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("views/SignUp.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    String id = request.getParameter("id");
	    String password = request.getParameter("password");
	    String email = request.getParameter("email");
	    boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
	    String fullName = request.getParameter("fullName");
	    Date birthday = null; 
	    try {
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        birthday = sdf.parse(request.getParameter("birthday"));
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	    boolean admin = Boolean.parseBoolean(request.getParameter("admin"));
	    
	    DAO_User dao = new DAO_User();
	    User user = dao.findByID(id);
	    if (user == null) {
	        User newUser = new User(id, password, email, gender, fullName, birthday, admin, null);
	        dao.insert(newUser);
	    } else {
	        System.out.println("Error: " + user);
	    }
	    response.sendRedirect("SignUp.jsp");
	}

}
