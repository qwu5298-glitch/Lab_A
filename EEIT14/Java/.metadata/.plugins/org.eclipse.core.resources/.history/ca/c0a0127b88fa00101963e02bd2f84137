package tw.brad.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet("/Brad32")
public class Brad32 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject obj = new JSONObject();
		obj.put("x", 10).put("y", 3);
		
		JSONArray ary = new JSONArray();
		ary.put("Brad").put("Alex").put("Mary");
		
		obj.put("names", ary);
		
		System.out.println(obj);
		
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(obj);
		response.flushBuffer();
	}

}