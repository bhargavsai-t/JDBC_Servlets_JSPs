# Connection Pooling and Advanced JDBC

## Connection pooling

1. It allows us to request the container to create a set of JDBC Connections right when it starts up.
2. They can be used by servlets or Jsp or any other web resource to do what they have to do and send the connection back once they are done with work.
3. The main advantages are
   - **Performance**: Even before the requests come in the container creates connections so when the request comes in our servlets or JSP can use these ready made connection to finish their job.
   - **Reuse**: Once a jsp or servlet is done with their work they return the connection back allowing other resources to use the connection.

## Configuring Connection Pooling

There are _two_ steps to configure connection pooling.

1. We need to copy the driver jar file to lib folder of tomcat. Tomcat needs this jar file to establish connection.
2. We have to configure a resource element in `context.xml`. It tells the tomcat about the database connection string, username, and password. This file present in conf file in tomcat installation directory.

```xml
      <Resource name="myDs" auth="Container" type="java.sql.DataSource" driverClassName="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost/jdbc" user="root" password="sql@8">

      <!--
      1. By setting auth to container, we are asking container to take care of authentication.
      2. Here the type is java.sql.DataSource, this class holds the implementation for connection pooling and tomcat implements this.
      3. driverClassName is the class name of the driver.
      4. url here is the url of the database and username and passwords are the credentials of the database.
       -->
```

## Acquiring Connection

Steps for Acquiring the connection

1. Connect to the naming service.
2. Look up for the DataSource
3. Get the connection from the DataSource.

Here is how we acquire the connection

```Java
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    try{
        Context context = new InitialContext();
        //This is naming service and the constructor of this internally initializes and load the implementation
        DataSource ds = (DataSource) context.lookup("java:comp/env/myDs");
        /*java:comp/env is root element and mandatory
        This method return Object so we need it to type cast to DataSource. It is a replacement of DriverManager*/
       Connection conn = ds.getConnection();
       System.out.println(conn);
    }
}
```
