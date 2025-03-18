<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" import="java.sql.*" session="true" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Registration</title>
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
        String fName = request.getParameter("fName");
        String lName = request.getParameter("lName");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        System.out.println(conn);
        PreparedStatement ps =
        conn.prepareStatement("insert into user values(?,?,?,?,?)");
        ps.setString(1,uName);
        ps.setString(2,fName);
        ps.setString(3,lName);
        ps.setString(4,password);
        ps.setString(5,email);
        int result = ps.executeUpdate();
        if(result>0){
        out.write("<h3>Your registration is successful
            "+fName+""+lName+"</h3>");
        }else{
        out.write("<h3>Contact Administrator</h3>");
        }
        %>
        <%
        try {
        conn.close();

        } catch (SQLException e) {
        e.printStackTrace();
        }

        %>

        <h3><a href="Login.html">Click here to login</a></h3>
    </body>
</html>