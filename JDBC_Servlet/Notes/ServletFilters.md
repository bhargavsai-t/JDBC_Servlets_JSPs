# Servlet Filters

1. A filter is a Java class that can intercept the request and response cycles of a servlet.
2. Filters can be used to perform common tasks such as authentication, logging, and compression.
3. Any logic that we want to execute before the servlet request is processed by the servlet can be put into the filter that is the pre-processing logic and any logic that we want to execute before the Servlet response goes back to the web client can also be put into the filter that is postprocessing.
4. Filters can be used to perform tasks that are common to all servlets in an application.
5. The filter can be easily implemented by implementing the filter interface and we mark it with `@Filter` annotation.
6. We can also configure a filter in `web.xml` file.
7. `@WebFilter("uri")`, the uri is the uri pattern of the servlet on which this filter should be applied to. instead of uri, if we add \*, it applies to all the servlets in the web application.

## Life cycle of Filter

1. The filter is initialized when the web application is started.
2. The life cycle of a filter is very similar to servlet.
3. The `init()` in filter takes a `FilterConfig config` object than that of `ServletConfig config`.
4. Instead of `service()` in servlet, in filter we have `doFilter()` that takes 3 arguments and looks like `doFilter(ServletRequest request, ServletResponse response, FilterChain chain){}`.
5. The filter chain has all the information for where the request should go next whether its another filter or another servlet.
6. By default all th filters are pre initialized unlike servlets.
7. `init()` and `destroy()` are only called once and `doFilter()` is called every time the filter is invoked.

## Filter Chaining

1. Filter chaining is a concept of a plane more than one filter to servlet or a JSP.

2. For example we can have multiple filters one filter doing encryption and decryption and then either filter or doing zipping and unzipping of that request and response. So it depends on a business requirement. You can how multiple filters handling multiple responsibilities each filter will do its job and then handle the request in response to the next filter in the chain.
