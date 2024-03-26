package Controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import DAO.userDAO;
import Model.User;


@WebServlet("/UserList")
public class userControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public userControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		userDAO dao = new userDAO();

		try {
			
			if (action == null || action.isEmpty()) {
				request.setAttribute("LIST_USER", dao.getAll());
				RequestDispatcher dispatcher = request.getRequestDispatcher("views/UserDisplay.jsp");
				dispatcher.forward(request, response);
			} else {
				switch (action) {
				case "AddOrEdit": {
				    String username = request.getParameter("userName");
				    User user = dao.findByUsername(username);
				    if (user == null) {
						user = new User();
					}
				    request.setAttribute("USER", user);
				    
				    RequestDispatcher dispatcher = request.getRequestDispatcher("views/SignUp.jsp");
				    dispatcher.forward(request, response);
				    break;
				}

				case "SaveOrUpdate": {
					DateConverter dc = new DateConverter(null);
					dc.setPattern("dd/MM/yyyy");
					ConvertUtils.register(dc, Date.class);

					User user = new User();
					BeanUtils.populate(user, request.getParameterMap());

					dao.save(user);

					request.setAttribute("LIST_USER", dao.getAll());
					RequestDispatcher dispatcher = request.getRequestDispatcher("views/UserDisplay.jsp");
					dispatcher.forward(request, response);
					break;
				}

				case "List": {
					request.setAttribute("LIST_USER", dao.getAll());
					RequestDispatcher dispatcher = request.getRequestDispatcher("views/UserDisplay.jsp");
					dispatcher.forward(request, response);
					break;
				}
				case "Delete": {
				    String username = request.getParameter("username");
				    boolean deleted = dao.delete(username);
				    if (deleted) {
				        // Xóa thành công
				        request.setAttribute("successMessage", "Người dùng đã được xóa thành công.");
				    } else {
				        // Không thể xóa người dùng
				        request.setAttribute("errorMessage", "Không thể xóa người dùng.");
				    }

				    // Cập nhật lại danh sách người dùng
				    request.setAttribute("LIST_USER", dao.getAll());
				    RequestDispatcher dispatcher = request.getRequestDispatcher("views/UserDisplay.jsp");
				    dispatcher.forward(request, response);
				    break;
				}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Lỗi khi xử lý yêu cầu");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
