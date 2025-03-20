package transactions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Transaction {

    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/jdbc", "root", "sql@8");
            Statement stmt = conn.createStatement();
            conn.setAutoCommit(false);
            stmt.executeUpdate("update account set bal=bal+500 where accno = 1");
            stmt.executeUpdate("update account set bal=bal-500 where accno = 2");
            conn.commit();

        } catch (Exception e) {
            e.getCause();
            e.getLocalizedMessage();
            try {
                conn.close();
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

    }
}
