package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletConfig;
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
	public void init(ServletConfig config) throws ServletException {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost/jdbc","root","sql@8");
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String uName = req.getParameter("username");
		String fName = req.getParameter("fName");
		String lName = req.getParameter("lName");
		String password = req.getParameter("password");
		
		try(Statement st = conn.createStatement();){
			st.executeUpdate("update user set fName='"+fName+"', lName='"+lName+"' where uName='"+uName+"' and password='"+password+"'");
					
		}catch(Exception e){
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
