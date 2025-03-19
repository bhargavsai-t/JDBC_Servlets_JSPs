<%@ taglib prefix="srirama" uri="http://srirama.com"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Display User Info</title>
    </head>
    <body>
        <srirama:displayuser />
        First Name:
        <br />
        <input type="text" value=<%=request.getAttribute("fName")%> />
        <br /> Last Name:
        <br />
        <input type="text" value=<%=request.getAttribute("lName")%> />
        <br /> User Name:
        <br />
        <input type="text" value=<%=request.getAttribute("uName")%> />
        <br /> email:
        <br />
        <input type="text" value=<%=request.getAttribute("email")%> />
        <br />
        <a href="index.html">Back</a>
    </body>
</html>