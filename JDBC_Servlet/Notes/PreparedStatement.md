# Prepared Statement

1. It is a child interface of the statement interface.
2. It is a precompiled version of a sequel statement.
3. We can create prepared statement using `PreparedStatement ps = Connection.prepareStatement("")`. Inside the method we will pass entire sql query.
4. The sql query in prepared statement look like `insert into user values(?,?,?);`. Instead of hard coding the values here or taking them dynamically we put them with question marks to mark the placeholders in a prepared statement.
5. The entire statement will  be compiled right here. And at later point in time, we set these values using `PreparedStatement.setXXX()` available on prepared statement.
6. These values are then passed to the database for execution. This is the main advantage of prepared statement. xxx are data types like int `setInt()`, string `setString()` and so on.
7. This step of setting parameters is called binding parameters.
8. After binding the parameters we simply use `PreparedStatement.executeQuery()`
9. Every time we are adding, only the parameters are getting replaced. There is no compilation that happen again and again.
10. Prepared statement is used to prevent SQL injection attacks.

```Java
PreparedStatement ps = conn.prepareStatement("insert into user values(?,?,?,?);");
ps.setInt(1);
ps.setString("Sri");
ps.setString("Rama");
ps.setInt(900);
ps.executeUpdate();
```

## Flow of statement object

- If you use the statement object to execute a select query or an update or insert statement, the first thing the that happens in the flow is that the JDBC client sends these statements through the driver one at a time to the database . The database will compile these statements.
- If there are any checks like syntax checking, if the queries are following sql specification; these checks are done during the compile time then it will execute that statement and sends back the appropriate result back to the client using driver.
-If we update the statement or if there are n statements, the compiling and checking of statements happen. This will degrade the performance of the application.
