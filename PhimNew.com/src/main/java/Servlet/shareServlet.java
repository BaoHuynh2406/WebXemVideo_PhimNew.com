package Servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAO_Share;
import DAO.DAO_User;
import DAO.DAO_Video;
import Entity.Share;
import Entity.Users;
import Entity.Video;

@WebServlet("/home/share")
public class shareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public shareServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Lấy thông tin từ request
		String userId = (String) request.getSession().getAttribute("userId"); // Lấy userId từ session
		String videoIdStr = request.getParameter("videoId");
		int videoId = Integer.parseInt(videoIdStr);
		String email = request.getParameter("email");

		if (userId == null || userId.isEmpty()) {
			response.sendRedirect("login.jsp");
			return;
		}

		if (email == null || email.isEmpty()) {
			request.setAttribute("error", "Please provide an email address");
			request.getRequestDispatcher("previous-page.jsp").forward(request, response);
			return;
		}

		// Lấy thông tin người dùng từ userId
		DAO_User daoUser = new DAO_User();
		Users user = daoUser.findByID(userId);
		if (user == null) {
			request.setAttribute("error", "User not found");
			request.getRequestDispatcher("previous-page.jsp").forward(request, response);
			return;
		}

		// Lấy thông tin video từ videoId
		DAO_Video daoVideo = new DAO_Video();
		Video video = daoVideo.findByID(videoId);
		if (video == null) {
			request.setAttribute("error", "Video not found");
			request.getRequestDispatcher("previous-page.jsp").forward(request, response);
			return;
		}

		// Tạo đối tượng Share
		Share share = new Share();
		share.setUser(user);
		share.setVideo(video);
		share.setEmails(email);
		share.setShareDate(new Date());

		// Thêm Share vào cơ sở dữ liệu
		DAO_Share daoShare = new DAO_Share();
		daoShare.insert(share);

		// Gửi email
		sendEmail(user.getFullName(), email, video.getTitle(), video.getPoster());

		response.sendRedirect("success.jsp");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	private void sendEmail(String senderName, String recipientEmail, String videoTitle, String videoPoster) {
		// Code để gửi email ở đây
		// Bạn có thể sử dụng thư viện JavaMail để gửi email từ máy chủ
		// Ví dụ:
		/*
		 * try { // Set up the email message Properties properties = new Properties();
		 * properties.put("mail.smtp.auth", "true");
		 * properties.put("mail.smtp.starttls.enable", "true");
		 * properties.put("mail.smtp.host", "smtp.gmail.com");
		 * properties.put("mail.smtp.port", "587");
		 * 
		 * Session session = Session.getInstance(properties, new Authenticator() {
		 * 
		 * @Override protected PasswordAuthentication getPasswordAuthentication() {
		 * return new PasswordAuthentication("your-email@gmail.com", "your-password"); }
		 * });
		 * 
		 * Message message = new MimeMessage(session); message.setFrom(new
		 * InternetAddress("your-email@gmail.com"));
		 * message.setRecipient(Message.RecipientType.TO, new
		 * InternetAddress(recipientEmail)); message.setSubject("Share Video");
		 * message.setText("Dear " + recipientName + ",\n\n" + senderName +
		 * " has shared the video \"" + videoTitle + "\" with you. Enjoy watching!\n\n"
		 * + "Video Poster: " + videoPoster);
		 * 
		 * Transport.send(message);
		 * 
		 * System.out.println("Email sent successfully."); } catch (MessagingException
		 * e) { e.printStackTrace(); }
		 */
	}
}
