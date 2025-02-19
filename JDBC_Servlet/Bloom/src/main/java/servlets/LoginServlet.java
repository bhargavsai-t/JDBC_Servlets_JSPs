package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private transient Connection conn;
       
   @Override
   public void init() {
	   try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost/jdbc","root","sql@8");
	} catch (Exception e) {
		e.printStackTrace();
	}
	   
   }
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uName = req.getParameter("username");
		String pass = req.getParameter("password");
		
		try(Statement st = conn.createStatement();
				PrintWriter out = res.getWriter();){
			ResultSet rs = st.executeQuery("select fName,lName from user where uName='"+uName+"' and password='"+pass+"';");
			while(rs.next()) {
				res.setContentType("text/html");
				out.write("Hello "+ rs.getString("fName") + " "+rs.getString("lName")+" <br>");
				out.write("If you want to update details <br>");
				out.write("<a href='UserUpdate.html'>Update Details</a>");
			}
		}catch(Exception e) {
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
