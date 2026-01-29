package tw.brad.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tw.brad.apis.Member;
import tw.brad.dao.MemberDAO;

@WebServlet("/Brad21")
public class Brad21 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		response.setContentType("text/html; charset=UTF=8");
		PrintWriter out = response.getWriter();
		
		
		String email = request.getParameter("email");
		String passwd = request.getParameter("passwd");
		if (email != null && passwd != null) {
			MemberDAO dao = new MemberDAO();
			try {
				Member member = dao.login(email, passwd);
				if (member != null) {
					HttpSession session = request.getSession(true);
					session.setAttribute("member", member);
					//-----
					int lottery = (int)(Math.random()*49+1);
					session.setAttribute("lottery", lottery);
					int[] ary = {1,2,3,4};
					session.setAttribute("ary", ary);
					//-----
					
					member.setName("New Brad");
					lottery = 100;
					ary[2] = 33;
					
					
					response.sendRedirect("Brad22");
				}else {
					response.sendRedirect("brad21.html");
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			
			
			
		}else {
			response.sendRedirect("brad21.html");
//			response.sendError(405);
//			response.sendError(487, "xxxxxxx");
		}
		
		
		response.flushBuffer();		
	
	}

}