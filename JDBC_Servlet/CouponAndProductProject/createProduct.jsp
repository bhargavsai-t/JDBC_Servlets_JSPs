<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Create Product</title>
    </head>
    <body>
        <h1>Create a Product</h1>
        <form action="CreateProduct" method="post">
            <pre>
<label for="name">Enter Name</label><br/>
<input type="text" name="name"/><br/>
<label for="price">Enter Price</label><br/>
<input type="number" name="price"/><br/>
<label for="description">Enter Description</label><br/>
<input type="text" name="description"/><br/>
<input type="submit" value="save"/>
</pre>
        </form>
    </body>
</html>