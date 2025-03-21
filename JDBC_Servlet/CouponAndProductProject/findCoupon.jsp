<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Find Coupon</title>
    </head>
    <body>
        <form action="CouponCreation" method="post">
            <label for="code">Enter Code</label><br />
            <input type="text" name="code" /><br />
            <input type="hidden" name="action" value="find" />
            <input type="submit" value="find" />

        </form>
    </body>
</html>