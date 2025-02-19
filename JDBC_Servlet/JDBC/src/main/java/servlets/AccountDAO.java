package servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AccountDAO {

	public static void main(String[] args) {
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/jdbc", "root", "sql@8");
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery("select accno, firstName, lastName from account");) {
				System.out.println(conn);
				while(rs.next()) {
					System.out.println("Account no is: "+rs.getInt("accno"));
					System.out.println("First Name is: "+rs.getString("firstName"));
					System.out.println("Last Name is: "+rs.getString("lastName"));
				}
		} catch (Exception e) {
			System.out.println("Error loading driver " + e.getStackTrace());
		}

	}
}
