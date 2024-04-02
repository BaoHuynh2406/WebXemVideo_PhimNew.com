package Controller;


import Entity.User;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/video")
public class videoControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public videoControl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		String name = req.getParameter("id");
		selectById(name, req);
		req.getRequestDispatcher("/views/videoDetail.jsp").forward(req, resp);
	}

	public void selectById(String name, HttpServletRequest request) throws ServletException, IOException {
		{
		
//			videoDAO dao = new videoDAO();
//			List<Video_item> items = dao.sellectAll();
//			Video_item select = null;
//			
//			for (Video_item item : items) {
//				if (item.getTitle().equalsIgnoreCase(name)) {
//					select = item;
//				}
//			}

//			System.out.println(select.getTitle());
//			// Lưu danh sách sản phẩm đã chọn vào request để chuyển tiếp tới trang JSP
//			request.setAttribute("select", select);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
