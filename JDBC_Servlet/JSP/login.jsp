<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" import="java.sql.*" session="true"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Profile</title>
    </head>
    <body style="text-align: center">
        <%!
        Connection conn;
        %>
        <%
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn =
        DriverManager.getConnection(application.getInitParameter("dbUrl"),application.getInitParameter("dbUser"),application.getInitParameter("dbPass"));
        %>
        <%
        String uName = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(conn);
        PreparedStatement ps =
        conn.prepareStatement("select uName, fName, lName, email from user where uName=? and password=?");
        ps.setString(1,uName);
        ps.setString(2,password);
        ResultSet rs = ps.executeQuery();
        String fName = null;
        String lName = null;
        String email = null;

        while(rs.next()){
        fName = rs.getString("fName");
        lName = rs.getString("lName");
        email = rs.getString("email");
        /*
        out.write("<label for='uName'>User Name</label><br>");
        out.write("<input type='text'
            value='"+rs.getString("uName")+"' /><br>");
        out.write("<label for='fName'>First Name</label><br>");
        out.write("<input type='text'
            value='"+rs.getString("fName")+"' /><br>");
        out.write("<label for='lName'>Last Name</label><br>");
        out.write("<input type='text'
            value='"+rs.getString("lName")+"' /><br>");
        out.write("<label for='email'>Email</label><br>");
        out.write("<input type='text'
            value='"+rs.getString("email")+"' /><br>");
        */
        }
        session.setAttribute("uName",uName);
        session.setAttribute("fName", fName);
        session.setAttribute("lName", lName);
        session.setAttribute("email", email);
        session.setAttribute("password", password);

        %>
        <%
        try {
        conn.close();

        } catch (SQLException e) {
        e.printStackTrace();
        }

        %>
        <form>
            <label for="uName">User Name</label><br>
            <input name="uName" type="text"
                value=<%=session.getAttribute("uName") %> readonly/> <br>
            <label for="fName">First Name</label><br>
            <input name="fName" value=<%=session.getAttribute("fName") %>
            readonly/><br>
            <label for="lName">Last Name</label><br>
            <input type="text" name="lName"
                value=<%=session.getAttribute("lName") %> readonly/><br>
            <label for="lName">email</label><br>
            <input type="text" name="email"
                value=<%=session.getAttribute("email") %> readonly/><br>
        </form>
        <h3><a href="userUpdate.jsp">Update your details here</a></h3>
        <h3><a href="Registration.html">Logout</a></h3>
    </body>
</html>