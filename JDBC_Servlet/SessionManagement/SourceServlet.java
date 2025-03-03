import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/SourceServlet")
public class SourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				System.out.println("Cookie: " + cookie.getName() + " " + cookie.getValue());
			}
		}
		response.addCookie(new Cookie("securityToken", "sriRama"));
		String user = request.getParameter("user");
		HttpSession s = request.getSession();
		s.setAttribute("user", user);
		response.setContentType("text/html");
		String url = "targetServlet?sessionId=123";
		response.getWriter().print("<a href='" + url + "'>Click here to get user name</a>");
	}

}
