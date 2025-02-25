# ServletContext

1. It is a library interface in the servlet API and it ives in the `javax.servlet` package.
2. The servlet container implements this interface and as soon as we deploy our application even before any client request comes in the servlet container creates the servlet context.
3. There is only one servlet context for the entire application and the container will destroy the servlet context when we undeploy our application from the container.
4. The data that we put in servlet context will be applicable through out the application, so any servlet, or JSP with in our application can access the servlet context and get data which is put by any other servlet or jsp or put the data which can be accessed by any servlet or jsp.
5. Scope of servlet context is throughout the application.
6. During the initialization phase of a servlet the container injects the servlet context object by creating it into the servlet and once injected we can retrieve it in different ways with in a servlet for a unique method that is overloaded init method that takes a `ServletConfig config` object which has a method `config.getServletContext()` from which you can retrieve the servlet context.
7. For `init()` that doesn't take any methods we simply use `ServletContext context = getServletContext()`.

## Uses of ServletContext

1. Store and access data at an application level. So we can set some data into the servlet context object in one servlet and we can then retrieve it in any other servlet in our application as the flow goes from one servlet to another. If we want to remove that attribute in any point of time we can remove it from any other servlet or jsp. Finally if we want to get all the attribute names that are being create din servlet context we can get by using `getAttributeNames()` and iterate over them to access. Methods: `setAttribute()`, `getAttribute()`, and `removeAttribute()`.
2. To deal with the context params.
3. To create the RequestDispatcher object for inter-servlet communication.
4. To store information into the server log files using the `log()`.

## Context Params

1. They are name:value pairs of textual information that are supplied through the `web.xml` for our web application. They are very similar to init params.
2. The major difference between these and init params are, init params are for particular servlet and these are application level.
3. In the `web.xml` we use element `<context-param></context-param>` not under servlet tag but it is a global tag. We can create any number of context params in `web.xml` file. All these params are read by the container when the application is deployed.
4. We can access these params in our servlet by using `getServletContext().getInitParameter()`.
5. We can also access these params in JSP by using `application.getInitParameter()`.

```xml
<context-param>
<param-name></param-name>
<param-value></para-value>
</context-param>
```
