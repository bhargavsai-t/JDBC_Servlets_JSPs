# Inter Servlet Communication or Request Dispatching

1. In our applications we just don't put all our code into one single servlet or a jsp page, we spread it across servlets and jsp's and these communicate with each other.
2. This is nothing but inter servlet communication or request dispatching.
3. So each of these components once they are done with their work they will dispatch the request to the next component which can do more work.
4. We call it request dispatching we use the request dispatcher interface in the servlet api to do that.
5. The request dispatcher interface has two methods forward and include.
6. We retrieve a request dispatcher from the request using the request dispatcher method.
7. The parameter for this is a uri to which we want to go next.
    `RequestDispatcher rd = request.getRequestDispatcher(uri)`
8. There are two ways in which request dispatcher requests can be done: 
    - `rd.forward(request,response)`
        - The request comes from the client.
        - Servlet 1 handles the request and then it needs to do more work or there is another component which needs to do more work it will forward that request to that servlet.
        - Servlet 2 handles that request and gives response back to the client.
        - Here the complete control lies in servlet 2 and the response goes from servlet 2.
        - The servlet 2 will get the same request and response which the containers give to servlet 1.
    - `rd.include(request,response)`
        - When the client request comes in.
        - There are multiple servlets or jsp's, when we use include from servlet 1 to servlet 2, the container will merge the response of these 2 and send it back to the client.
        - The control doesn't goes to the second servlet, the container simply merges all the responses.
        - The request and response is shared across the components.