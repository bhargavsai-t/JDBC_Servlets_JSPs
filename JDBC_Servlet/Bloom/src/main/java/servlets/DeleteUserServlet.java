package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private transient Connection conn;

	@Override
	public void init(ServletConfig sc) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(sc.getInitParameter("dbUrl"),sc.getInitParameter("dbUser"),sc.getInitParameter("dbPass"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uName = req.getParameter("username");
		String password = req.getParameter("password");
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		try (Statement st = conn.createStatement();) {
			int result = st
					.executeUpdate("delete from user where uName='" + uName + "' and password = '" + password + "'");
			if (result > 0) {
				out.print("User Deletion Successful <br>");
				out.print("If you want to register again <br>");
				out.print("<a href='Registration.html'>Register Here</a>");
			} else {
				out.print("Try again");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void destroy() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}