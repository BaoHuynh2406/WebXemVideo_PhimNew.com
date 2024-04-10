package Utils;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
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
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class senemail {
	public static void guimail(String nguoinhan, String NDemail) {
		
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
	                return new javax.mail.PasswordAuthentication(username, password);
	            }
	        });

	        String emailTo = nguoinhan;
	        String emailSubject = "Mật mã khôi phục";
	        String emailContent = NDemail;
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
	          
	        }
	}
}
