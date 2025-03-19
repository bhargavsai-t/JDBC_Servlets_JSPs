import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.Tag;
import jakarta.servlet.jsp.tagext.TagSupport;

public class TagHandler extends TagSupport {

    private static final long serialVersionUID = -4809144918492452085L;
    private transient Connection conn;
    private transient PreparedStatement ps;

    public TagHandler() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/jdbc", "root", "sql@8");
            ps = conn.prepareStatement("select fName, lName, uName, email from user where email=?");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int doStartTag() throws JspException {
        ServletRequest request = pageContext.getRequest();
        String email = request.getParameter("email");
        try {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                request.setAttribute("fName", rs.getString("fName"));
                request.setAttribute("lName", rs.getString("lName"));
                request.setAttribute("uName", rs.getString("uName"));
                request.setAttribute("email", rs.getString("email"));
            } else {
                JspWriter out = pageContext.getOut();
                out.print("User Not Found :( <br/>");
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

        return Tag.SKIP_BODY;
    }

    @Override
    public void release() {

        try {
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
