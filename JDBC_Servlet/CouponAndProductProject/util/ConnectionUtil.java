package util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionUtil {

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Context c = new InitialContext();
            DataSource dataSource = (DataSource) c.lookup("java:comp/env/myds");
            conn = dataSource.getConnection();
        } catch (NamingException | SQLException e) {
            e.getCause();
            e.getLocalizedMessage();
        }
        return conn;
    }

    public static void main(String[] args) {
        System.out.println(getConnection());
    }
}
