<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Create Coupon</title>
    </head>
    <body>
        <h1>Create a Coupon</h1>
        <form action="CouponCreation" method="post">
            <pre>
<label for="code">Enter Code</label><br/>
<input type="text" name="code"/><br/>

<label for="discount">Enter Discount</label><br/>
<input type="number" inputmode="decimal" name="discount"/><br/>

<label for="expDate">Enter Expiry Date</label><br/>
<input type="text" name="expDate"/><br/>
<input type="hidden" name="action" value="create"/>
<input type="submit" value="save"/>
</pre>
        </form>
    </body>
</html>