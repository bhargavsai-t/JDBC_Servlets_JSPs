package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private transient Connection conn;

	@Override
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			ServletContext servletContext = getServletContext();
			conn = DriverManager.getConnection(servletContext.getInitParameter("dbUrl"),
					servletContext.getInitParameter("dbUser"), servletContext.getInitParameter("dbPass"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uName = req.getParameter("username");
		String fName = req.getParameter("fName");
		String lName = req.getParameter("lName");
		String password = req.getParameter("password");

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		try (Statement st = conn.createStatement();) {
			int result = st.executeUpdate("update user set fName='" + fName + "', lName='" + lName + "' where uName='"
					+ uName + "' and password='" + password + "'");
			if (result > 0) {
				out.write("Done!!");
			} else {
				out.write("Bad Credentials or contact administrator");
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
