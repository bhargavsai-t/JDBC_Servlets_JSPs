# JDBC

## Components of JDBC Architecture

- **JDBC Driver**: This is the interface between the Java application and the database. It is responsible for translating JDBC calls into database-specific commands.
- **JDBC API**: This is a set of classes and interfaces provided by the Java platform for database connectivity. It includes classes like `DriverManager`, `Connection`, `Statement`, `ResultSet`, etc.
- **Database**: This is the actual database system where the data is stored. It can be any relational database like MySQL, PostgreSQL, Oracle, etc.
- **JDBC Client**: This is the Java application that uses the JDBC API to interact with the database.
- **Driver Manager**: This is a class that manages a list of database drivers. It matches connection requests from the client with the appropriate driver.

## JDBC API

1. Oracle provides two things; API and Specification. We as developers we learn API and use it in our application. But we don't know how it is implemented. That is the responsibility of Oracle. Oracle implements the API and provides the implementation as a JAR file. This JAR file is called as Driver.
2. It is a part of `java.sql.*` package. It contains interfaces and classes for JDBC API.
3. API is comprised of several interfaces and classes like connection statement, resultset and many more.

## JDBC Driver

1. Driver is a software component that enables Java application to interact with the database. It acts as a bridge between the Java application and the database.
2. It acts as a translator. It translates the JDBC calls into database specific commands.
3. These driver implements JDBC API and JDBC specification which oracle provides. It is a JAR file. It is provided by the database vendor. For example, MySQL provides MySQL driver, Oracle provides Oracle driver, etc.

## JDBC Client

1. A JDBC client is a program that we are developing. To interact with the database. It uses JDBC API to interact with the database. It is a Java application.
2. _Cycle of JDBC Client_:
   1. Load the driver.
   2. Establish the connection.
   3. Create the statement (CRUD Operation).
   4. Execute the query.
   5. Process the result (That is if it is a create or update or delete statement; DML statement. We ge the number of rows that are impacted in the database and if it is a read operation we get the row themselves back which we need to process).
   6. Close the connection.

```java
// JDBC Driver Registration
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

// Establishing Connection
Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "username", "password");

// Creating Statement
Statement stmt = conn.createStatement();

// Executing Query
ResultSet rs = stmt.executeQuery("SELECT * FROM table_name");

// Processing Result
while (rs.next()) {
    System.out.println(rs.getString(1) + " " + rs.getString(2));
}

// Closing Connection
rs.close();
stmt.close();
conn.close();
```

This is a basic example of how to use JDBC API to interact with the database.

## Driver Manager

1. It is a class in JDBC API that is used to load the driver and establish the connection.
2. It acts a key holder or helper in between the driver and our java application itself.
3. It is used only once to find the appropriate driver to connect to the database.
4. Our java client or java application will directly communicate with the driver to execute all the `sql` operations.

## Steps to perform CRUD

1. Every dynamic java application performs one or all of the CRUD operations against the database it uses.
2. This is create, read, update, and delete through the DML and DQL sql statements that are insert, update, delete, and select to perform those operations from within a JDBC client program.
3. There are five important steps:
   1. Establishing the Connection.
   2. Creating statement object.
   3. Execute the statement object.
   4. Close the statement object.
   5. Close the connection object.

## Parameters in DriverManager constructor

1. `DriverManager.getConnection("jdbc:mysql://localhost/db-name","username","password");`.
2. `jdbc:mysql://localhost/db-name`: This is the URL of the database. It is the address of the database that we are trying to connect to.
3. `username`: Username of the database administrator.
4. `password`: Password of the database administrator.