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
import Entity.Users;




@WebServlet("/SignUp")
public class DangKy_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DangKy_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		request.getRequestDispatcher("views/SignUp.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Users user = new Users();
		
		if(create(request, response)) {
			try {
				Thread.sleep(5000);
				response.sendRedirect("/PhimNew/login");
				return;
			} catch (InterruptedException e) {
				request.setAttribute("error", e.getMessage());
			}
		}
		request.getRequestDispatcher("views/SignUp.jsp").forward(request, response);
	}
	
	protected boolean create(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    // TODO Auto-generated method stub
	    try {
	        Users user = new Users();
	        BeanUtils.populate(user, request.getParameterMap());
	        DAO_User dao = new DAO_User();
	        
	        if (dao.findByID(user.getId()) != null) {
	            request.setAttribute("error", "Error: User đã tồn tại");
	            return false;
	        } else {
	            dao.insert(user);
	            request.setAttribute("message", "Create success!");
	            return true;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        request.setAttribute("error", "Error: " + e.getMessage());
	        return false;
	    }
	}


}
