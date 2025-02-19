# Init Parameters

1. These are name value pairs of textual information supplied to the servlet declaratively through `web.xml` file during initialization phase.
2. These could be the location of a folder where you want all the uploaded files to be saved to or it could be simply thr database as username and password the information itself these names and values.
3. We create these params in web.xml file inside the `<servlet></servlet>` element.

   ```java
   <servlet>
   <servlet-name>MyServlet</servlet-name>
   <servlet-class>MyServlet</servlet-class>
   <init-param>
   <param-name>param1</param-name>
   <param-value>value1</param-value>
   </servlet>
   ```

4. We can then access these parameters in the servlet class using the `getInitParameter()` method.
5. The container will create a servlet config object, it reads the web.xml file and then it uses this information and it sets the information into the servlet config.

   ```java
    // The init method will look like
    public void int(ServletConfig config){
        String param1 = config.getInitParameter("param1");
    }
   ```

6. The main object of using init params is will not have any hard code values, so you will not be hard coding your database user names and passwords so if anytime the database information is changed we don't have to go each and every servlet to change those values instead we change in web.xml file.
7. We can configure any number of init params and we can retrieve them.

## Passing Init Params in annotations and not in web.xml file

1. We can pass init params in Annotations also.
2. The `@WebServlet` annotation looks like the following.

```java
@WebServlet(name = "MyServlet", urlPatterns = "/MyServlet", initParams = {@WebInitParam(name="",value=""),@WebInitParam(name="",value="")});
```
