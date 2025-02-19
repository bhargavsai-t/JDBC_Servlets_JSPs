# Servlets

## Servlets Introduction

1. Servlets are Java classes that run on a web server and are used to handle HTTP requests and responses.
2. They are a fundamental part of the Java Servlet API and are used to create dynamic web applications.
3. Servlets are typically used to handle user requests, interact with databases, and generate dynamic content.

## Life cycle methods of servlets

1. There are three life cycle methods.
2. `init()`: This method is called when the servlet is initialized. It is used to perform any initialization tasks, such as loading configuration.
3. `service()`: This method is called when a request is received by the servlet. It is used to handle the request and generate a response.
4. `destroy()`: This method is called when the servlet is destroyed. It is used to perform any cleanup tasks, such as releasing resources.

## Servlet vs Servlets in Java

1. Servlet is a class that implements the Servlet interface. Servlets has API and specification. API is for developers to develop dynamic web applications and specification is for servers to implement those servlets and written in plain english.
2. On the other hand, Servlet is a java program that runs on web container. it handles requests and generates responses dynamically and connect to the database.

## Servlet Annotations

1. 3.o version of servlets introduces annotations that can be used to configure various servlet components instead of using `web.xml`.
2. If you define the same component a servlet a filter and in it parameters in web.xml as well as using annotations. Then the web.xml will override the ones you define using annotations.

## Element to register servlet and map with URI

1. In the web.xml file, there is a `<servlet>` element that is used to register a servlet.
2. The `<servlet-name>` element is used to specify the name of the servlet.
3. The `<servlet-class>` element is used to specify the fully qualified name of the servlet class.
4. The `<servlet-mapping>` element is used to map a servlet with a URI.
5. The `<servlet-name>` element is used to specify the name of the servlet.
6. The `<url-pattern>` element is used to specify the URI.\
7. Or we can just register using annotation `@WebServlet(urlPatterns = "")`.

## HTML and Servlet

1. We can capture input from HTML form using servlets.
2. The `getParameter()` method is used to capture the input from the HTML form.
3. We use name can also use `getParameterValues()` method to capture multiple values from the HTML form.
4. We can use name attribute in html to capture the input from the HTML form.
5. We can specify the action using uri-pattern in form action attribute and using methods like get/post.
   Eg:

```html
<form action="servlet1" method="get">
  <input type="text" name="name" />
  <input type="submit" value="Submit" />
</form>
```

```java
String name = request.getParameter("name");
```
