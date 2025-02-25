import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ProductServlet", asyncSupported = true, urlPatterns = { "/ProductServlet" }, initParams = {
		@WebInitParam(name = "dbUrl", value = "jdbc:mysql://localhost/jdbc"),
		@WebInitParam(name = "dbUser", value = "root"), @WebInitParam(name = "dbPass", value = "sql@8") })
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private transient Connection conn;

	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(config.getInitParameter("dbUrl"), config.getInitParameter("dbUser"),
					config.getInitParameter("dbPass"));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String desc = request.getParameter("desc");
		int price = Integer.parseInt(request.getParameter("price"));
		response.setContentType("text/html");
		try (PreparedStatement ps = conn.prepareStatement("insert into prduct values(?,?,?,?)");) {

			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, desc);
			ps.setInt(4, price);
			int result = ps.executeUpdate();
			PrintWriter out = response.getWriter();
			if (result > 0) {
				out.print("Product Registry Done!! <br>");
				out.print(
						"<a href='ProductEntry.html' style='text-decoration: none;'>Click here to register another product</a>");
			} else {
				out.print("Contact Administrator :(");
			}
		} catch (SQLException | IOException e) {
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
