# Pre Initialization

1. There are two ways that can be initialized the _lazy way_ and the _pre initialization method_.
2. If a servlet container initializes the servlet only when the first web client request comes in then it is called lazy way. And it is by default.
3. If the container initializes the servlet even before the client request comes in that is pre initialization.
4. We can request the container to do pre initialization by using the `<load-on-startup></load-on-startup>` element in the `web.xml`.
5. This element is child element of the `<servlet></servlet>` and it takes the numerical value as its data.
6. This numeric value tells the container the priority of the servlet.
7. If there are multiple servlets that are being loaded on start up or that are pre initialized with in our application then this number here tells the container which one should be loaded first.
8. Lower the number higher the priority.

```java
<servlet>
<servlet-name></servlet-name>
<servlet-class></servlet-class>
<load-on-startup>1</load-on-startup>
</servlet>
```

`@WebServlet(urlPatterns"", load-on-startup=)` 9. We can also use the `@WebServlet` annotation to load the servlet on start up.
