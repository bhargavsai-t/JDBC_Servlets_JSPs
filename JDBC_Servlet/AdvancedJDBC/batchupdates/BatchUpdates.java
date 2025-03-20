package batchupdates;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchUpdates {

	public static void main(String[] args) {
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/jdbc", "root", "sql@8");
				Statement st = conn.createStatement();) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println(conn);
			st.addBatch("insert into user values('hello','hello','hello','hello','hello@gmail.com')");
			st.addBatch("insert into user values('hi','hi','hi','hi','hi')");
			st.addBatch("update user set uName='sriRama' where email='srirama@gmail.com'");
			int[] result = st.executeBatch();
			for (int i : result) {
				if (i > 0) {
					System.out.println("Query Processed");
				} else {
					System.out.println("Error");
				}
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.getCause();
			e.getMessage();

		}

	}
}
