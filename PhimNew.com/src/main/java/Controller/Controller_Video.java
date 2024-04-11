package Controller;

import java.awt.RenderingHints.Key;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import DAO.DAO_Video;
import Entity.Video;


@MultipartConfig
@WebServlet({"/Controller_Video","/Controller/VideoCreate","/Controller/VideoUpdate","/Controller/VideoDelete","/Controller/VideoEdit","/Controller/VideoReset"})
public class Controller_Video extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAO_Video daovd = new DAO_Video();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		
		if(uri.contains("VideoDelete")) {
			delete(request, response);
		}
		if(uri.contains("VideoEdit")) {
			edit(request, response);
		}
		findAll(request, response);
		request.getRequestDispatcher("/views/video.jsp").forward(request, response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");		
		
		String uri = request.getRequestURI();
		if(uri.contains("VideoCreate")) {
			create(request, response);
		}
		if(uri.contains("VideoUpdate")) {
			update(request, response);
		}
		if(uri.contains("VideoDelete")) {
			delete(request, response);
		}
		if(uri.contains("VideoEdit")) {
			edit(request, response);
		}
		if(uri.contains("VideoReset")) {
			reset(request, response);
		}
		findAll(request, response);
		request.getRequestDispatcher("/views/video.jsp").forward(request, response);	}
	
	private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Video> list = daovd.findAll();
			request.setAttribute("videos", list);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: "+e.getMessage());
		}
	}
	
	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
        Video video = new Video();
        BeanUtils.populate(video, request.getParameterMap());

        // Thêm URL từ request vào đối tượng video
        video.setUrl(request.getParameter("url"));

        File dir = new File(request.getServletContext().getRealPath("/img"));

        if (!dir.exists()) {
            dir.mkdirs();
        }

        Part videoImage = request.getPart("poster");
        System.out.println("videoImage: " + videoImage);
        File imageFile = new File(dir, videoImage.getSubmittedFileName());

        File dst = new File("ASM_JV4_WebsiteXemVideo/PhimNew.com/src/main/webapp/views/src/img", imageFile.getName());
        if (!dst.getParentFile().exists()) {
            dst.mkdirs();
        }

        videoImage.write(imageFile.getAbsolutePath());

        Path from = Paths.get(imageFile.getAbsolutePath());
        Path to = Paths.get(dst.getAbsolutePath());
        Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);

        video.setPoster(imageFile.getName());

        System.out.println("VideoId: " + video.getId() + "|Active: " + video.isActive() + "|Des: " + video.getDes() + "|Poster: " + video.getPoster() + "|Title: " + video.getTitle() + "|Views: " + video.getViews() + "|URL: " + video.getUrl());
        daovd.insert(video);
        request.setAttribute("message", "Video created Successfully!");

    } catch (Exception e) {
        e.printStackTrace();
        request.setAttribute("message", "Database Error or VideoID existed!");
    }
}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Video video = new Video();
			BeanUtils.populate(video, request.getParameterMap());

			Part part = request.getPart("poster");
			String realPath = request.getServletContext().getRealPath("/Posters");
			String fileName = Path.of(part.getSubmittedFileName()).getFileName().toString();
			
			if(!Files.exists(Path.of(realPath))) {
				Files.createDirectories(Path.of(realPath));
			}
			System.out.println("RealPath: "+realPath);
			System.out.println("FileName: "+fileName);
			
			if(fileName.trim().length()>0) {
				part.write(realPath+"/"+fileName);
				File dst = new File("views/src/img",fileName);
				if(!dst.getParentFile().exists()) {
					dst.mkdirs();
				}
				
				Path from = Paths.get(realPath+"/"+fileName);
				Path to = Paths.get(dst.getAbsolutePath());
				Files.copy(from, to,StandardCopyOption.REPLACE_EXISTING);
				video.setPoster(fileName);

				daovd.update(video);
				request.setAttribute("disabled", "");
				request.setAttribute("message", "Video updated Successfully!");
			}else {
				String fileName1 = (String) request.getSession().getAttribute("myImage");
				System.out.println("Filename: "+fileName1);
				video.setPoster(fileName1);
				
				daovd.update(video);
				request.setAttribute("disabled", "");
				request.setAttribute("message", "Video updated Successfully!");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("disabled", "disabled");
			request.setAttribute("message", e.getMessage());
		}
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
	        String getID = request.getParameter("videoID");
	        if (getID != null) {
	            int videoID = Integer.parseInt(getID);
	            daovd.delete(videoID);
	            request.setAttribute("disabled", "");
	            request.setAttribute("message", "Video deleted Successfully!");
	        } else {
	            request.setAttribute("message", "No video selected?");
	        }
	    } catch (NumberFormatException e) {
	        e.printStackTrace();
	        request.setAttribute("error", "Invalid video ID format");
	    } catch (Exception e) {
	        e.printStackTrace();
	        request.setAttribute("error", e.getMessage());
	    }
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {						
	        String getID = request.getParameter("videoID");
	        if (getID != null) {
	            Integer videoID = Integer.parseInt(getID);
	            Video video = daovd.findByID(videoID);
	            System.out.println("Edit image: " + video.getPoster());
	            request.setAttribute("disabled", "disabled");
	            request.setAttribute("video", video);
	        } else {
	            request.setAttribute("message", "No video ID provided");
	            request.setAttribute("disabled", "");
	        }
	    } catch (NumberFormatException e) {
	        e.printStackTrace();
	        request.setAttribute("error", "Invalid video ID format");
	        request.setAttribute("disabled", "");
	    } catch (Exception e) {
	        e.printStackTrace();
	        request.setAttribute("error", e.getMessage());
	        request.setAttribute("disabled", "");
	    }
	}

	private void reset(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("video", new Video());
		request.setAttribute("disabled", "");
	}
}
