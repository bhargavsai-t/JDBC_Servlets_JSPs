# ServletContext

1. It is a library interface in the servlet API and it ives in the `javax.servlet` package.
2. The servlet container implements this interface and as soon as we deploy our application even before any client request comes in the servlet container creates the servlet context.
3. There is only one servlet context for the entire application and the container will destroy the servlet context when we undeploy our application from the container.
4. The data that we put in servlet context will be applicable through out the application, so any servlet, or JSP with in our application can access the servlet context and get data which is put by any other servlet or jsp or put the data which can be accessed by any servlet or jsp.
5. Scope of servlet context is throughout the application.
6. During the initialization phase of a servlet the container injects the servlet context object by creating it into the servlet and once injected we can retrieve it in different ways with in a servlet for a unique method that takes