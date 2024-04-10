package Servlet;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        String videoIdStr = request.getParameter("videoId");
        int videoId = Integer.parseInt(videoIdStr);
        String email = request.getParameter("email");

        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user"); 
        String userId = null;
        if (user != null) {
            userId = user.getId();
        } else {
            System.out.println("Lỗi userId");
            response.sendRedirect("login.jsp");
            return;
        }

        if (email == null || email.isEmpty()) {
            request.setAttribute("Lỗi email", "Lỗi email");
            return;
        }

        if (userId == null || userId.isEmpty()) {
            response.sendRedirect("login.jsp");
            return;
        }

        DAO_Video daoVideo = new DAO_Video();
        Video video = daoVideo.findByID(videoId);
        if (video == null) {
            request.setAttribute("error", "Video not found");
            return;
        }

        Share share = new Share();
        share.setUser(user);
        share.setVideo(video);
        share.setEmails(email);
        share.setShareDate(new Date());

        DAO_Share daoShare = new DAO_Share();
        daoShare.insert(share);

        sendEmail(user.getFullName(), email, video.getTitle(), "http://localhost:8080/PhimNew/home#!/watch?id=" + videoId, request,
                response);

        response.sendRedirect("success.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String emails = request.getParameter("e");
        String conten = request.getParameter("conten");
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        String userId = null;
        if (user != null) {
            userId = user.getId();
        } else {
            System.out.println("Lỗi userID");
        }
        String videoIdStr = request.getParameter("videoId");
        int videoId = Integer.parseInt(videoIdStr);

        System.out.println(emails + " - " + conten + " - " + userId + " - " + videoId);

        Share share = new Share();
        share.setEmails(emails);
        share.setShareDate(new Date());

        DAO_Share daoShare = new DAO_Share();
        daoShare.insertShare(share, userId, videoId);

        sendEmail(user.getFullName(), emails, conten, "http://localhost:8080/PhimNew/home#!/watch?id=" + videoId, request, response);
    }


    private void sendEmail(String senderName, String recipientEmail, String videoTitle, String videoLink,
            HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String username = "lynguyenhoa102@gmail.com";
        final String password = "ajxbvpfopcatttpr";

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.debug", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        String emailTo = recipientEmail;
        String emailSubject = "Share Video";
        String emailContent = "Dear " + recipientEmail + ",\n\n" + senderName + " has shared the video \"" + videoTitle
                + "\" with you. Enjoy watching!\n\n" + "Video Link: " + videoLink;
        String message = "";

        try {
            Message mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(username));
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
            mimeMessage.setSubject(emailSubject);

            Multipart multipart = new MimeMultipart();

            // Adding text content
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(emailContent);
            multipart.addBodyPart(messageBodyPart);

            mimeMessage.setContent(multipart);

            Transport.send(mimeMessage);
            message = "Gửi email thành công!";
            System.out.println("Done");
        } catch (MessagingException e) {
            e.printStackTrace();
            message = "Gửi email thất bại: " + e.getMessage();
            log("Error sending email: " + e.getMessage());
        }

        req.setAttribute("message", message);
        req.getRequestDispatcher("/SendMail.jsp").forward(req, resp);
    }
}

