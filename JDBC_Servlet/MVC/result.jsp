<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Result</title>
    </head>
    <body>
        <h1>MVC Demonstration</h1>
        <h3>
            The average of
            <%=request.getAttribute("num1")%>
            and
            <%=request.getAttribute("num2")%>
            is
            <%=request.getAttribute("result")%>.
        </h3>
        <a href="Numbers.html" style="text-decoration:none;">Click here to try
            another</a>
    </body>
</html>