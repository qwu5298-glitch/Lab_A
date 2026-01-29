package tw.brad.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.brad.apis.Gift;
import tw.brad.dao.GiftDAO;

@WebServlet("/GiftSearch")
public class GiftSearch extends HttpServlet {
	private GiftDAO dao;
	
	@Override
	public void init() throws ServletException {
		dao = new GiftDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	
		try {
			String key = request.getParameter("key");
			List<Gift> gifts = dao.search(key);
			
			request.setAttribute("results", gifts);
			request.setAttribute("key", key);
			
			request.getRequestDispatcher("gifts.jsp").forward(request, response);
		}catch(Exception e) {
			System.out.println(e);
		}
	
	}

}