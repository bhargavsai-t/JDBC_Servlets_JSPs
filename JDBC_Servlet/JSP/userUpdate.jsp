<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" import="java.sql.*" session="true"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Update</title>
    </head>
    <body>
        <%
        String uName = (String)session.getAttribute("uName");
        String fName = (String)session.getAttribute("fName");
        String lName = (String)session.getAttribute("lName");
        String email = (String)session.getAttribute("email");
        String password = (String)session.getAttribute("password");
        %>

        <h1>Update Details</h1>
        <form action="UserUpdateServlet" method="post">
            <label for="username">User name:</label>
            <input type="text" id="username" name="username" value=<%=uName %>
            readonly><br><br>
            <label for="fName">First Name</label>
            <input type="text" id="fName" name="fName" value=<%=fName %>
            ><br><br>
            <label for="lName">Last Name</label>
            <input type="text" id="lName" name="lName" value=<%=lName %>
            required><br><br>
            <label for="email">Password:</label>
            <input type="email" id="email" name="email"
                value=<%=email %> readonly><br><br>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password"
                value=<%=password %> readonly><br><br>
            <input type="submit" value="Update">
        </form>
        <a href="login.jsp">Back</a>
    </body>
</html>