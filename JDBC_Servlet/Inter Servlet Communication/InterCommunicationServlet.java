import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/InterCommunicationServlet")
public class InterCommunicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/jdbc", "root", "sql@8");
				PreparedStatement ps = conn
						.prepareStatement("select fName from user where email = ? and password = ?");) {
			Class.forName("com.mysql.cj.jdbc.Driver");

			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			RequestDispatcher rd = request.getRequestDispatcher("HomeServlet");
			if (rs.next()) {
				request.setAttribute("message", "Welcome to Interservlet Communication");
				rd.forward(request, response);
			} else {
				rd = request.getRequestDispatcher("Login.html");
				rd.include(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
