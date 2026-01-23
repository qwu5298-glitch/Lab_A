package tw.brad.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.brad.apis.Gift;
import tw.brad.dao.GiftDAO;

@WebServlet("/GiftMain")
public class GiftServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. User
		request.setCharacterEncoding("UTF-8");
		int page = 1;
		try {
			page = Integer.parseInt(request.getParameter("page"));
		}catch(Exception e) {}
		
		// 2. Model
		try {
			List<Gift> gifts = new GiftDAO(page, 10).findAll();
			if (gifts != null) {
				System.out.println(gifts.size());
			}else {
				System.out.println("gift null");
			}
			
			request.setAttribute("gifts", gifts);
			request.setAttribute("prev", page - 1);
			request.setAttribute("page", page);
			request.setAttribute("next", page + 1);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// 3. Viewer
		request.getRequestDispatcher("GiftViewer").forward(request, response);
	}

}