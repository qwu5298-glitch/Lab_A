package tw.brad.filter;

import java.io.IOException;
import java.util.Set;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/*")
public class AuthFilter extends HttpFilter implements Filter {
	private static final Set<String> WHITE_LIST = Set.of(
			"/login","/checkAccount" ,"/public","/css","/js","/imgs"
			);
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		String ctx = req.getContextPath();
		String uri = req.getRequestURI();
		System.out.println(ctx);
		System.out.println(uri);
		String path = uri.substring(ctx.length());
		System.out.println(path);
		
		HttpSession session = req.getSession(false);
		if (session != null) {
			chain.doFilter(request, response);
			return;
		}
		
		
		for (String prefix : WHITE_LIST) {
			if (path.startsWith(prefix)) {
				chain.doFilter(request, response);
				return;
			}
		}
		
		resp.sendError(403, "權限不足");
		
		
		
		
	}

}