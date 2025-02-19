package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/BloomRegisterServlet")
public class BloomRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private transient Connection conn;

	@Override
	public void init() throws ServletException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/jdbc", "root", "sql@8");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uName = req.getParameter("username");
		String fName = req.getParameter("fName");
		String lName = req.getParameter("lName");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		System.out.println(conn);
		try (Statement st = conn.createStatement();) {
			int result = st.executeUpdate("insert into user values('" + uName + "','" + fName + "','" + lName + "','"
					+ password + "','" + email + "')");
			PrintWriter out = res.getWriter();
			if (result > 0) {
				res.setContentType("text/html");

				out.write("User Registration Done");
				out.write("<a href='Login.html'>Click to login</a>");
			} else {
				out.write("faild:(");
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
