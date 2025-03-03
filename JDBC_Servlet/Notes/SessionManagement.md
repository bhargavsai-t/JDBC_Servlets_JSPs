# Session Management

## Http as stateless server

1. Http is a stateless server.
2. Each request is independent of the previous one.
3. If a protocol is stateless it means the server does not maintain a continuos connection once the server handles the request and sends back the response.
4. There is no alive socket connection, it is destroyed.

### Advantages of http being stateless

1. **Performance**: Since http is stateless, the server need not have to maintain the overhead of connection. If the client is not doing anything with the server the server need not maintain the connection as soon as response is gone. The server closes the connection or kills the socket.
2. **Scalability**: We can easily scale our applications. That is the same application can be deployed across applications servers not one single server but many servers.

### Disadvantages of http being stateless

1. We cant maintain the state like shopping cart or if you want to remember anything from the previous request.

## Steps to create session management

1. Create the session using

   ```java
   HttpSession session = request.getSession(true);
   ```

   - If we invoke the get session method inside our servlet we can get a http session object that servlet container creates and hand it over to you.

2. When you call the get session method from that point we can use the methods available on this http session to handle the session. We can set whatever we want on to this session object and it will live across multiple user requests.
3. Finally we close the session.

## How `getSession()` actually works?

1. When we invoke the http servlet `request.getSession()` in our servlet, the web server like _tomcat_ will check to see the incoming http request has a **session id**.
2. If it is not there then the web container will generate a unique session id for that web client and it will associate the newly created session with that unique id and the hands over this http session object to our servlet so that we can store information in it and maintain the state.
3. Then it will send the response back to the client along with this session id.
4. When the client makes the next request to the server, the server will check to see if the session is already registered or not. If it is registered then it will use that session and if there isn't it will create a new session for the data.

## Session Tracking

1. It is a way to maintain the state of the user across multiple requests.
2. Session is termed ad whatever happens right from the time a user logs into our web application till he logs out and also tracking the user interaction.
3. Things to remember in session; Client/User Identification and state maintenance.

## Ending Session

1. There are two ways in which a session could end.
   - **Invalidate()**: This method is used to invalidate the session. When user/client want to explicitly logout the session by clicking on log out. This method tells the container to kill the session.
   - **Session Expiry**: If an user is inactive for a particular period of time then the container will kill the session. Web container is responsible for destroying the session. We specify some time after that time it will kill the session. For _tomcat_ the session expiry time is 30 minutes. But we can override the session expiry. There are two ways to do that - We can set `session.setMaxInactiveInterval(600);`. Here the parameter values is in seconds. - Handling it with `web.xml` file. In the file there is a element called `<session-config></session-config>` which has the child element `<session-timeout></session-timeout>` which takes value in minutes.

## Cookies

1. HTTP Cookies are name value pairs of textual information that can be used to exchange data between the webserver client and web browser as a part of http headers.
2. We can pass any kind of information as a part of these cookies but usually cookies are used to maintain session between a web container and the web client.
3. In the world of java EE the n ame of the cookies that is used for session management is `jSessionId`.
4. When the first request is being sent by the web client, the web container will create a unique `jSessionId`, this will be created on the fly.
5. When the response is sent back from the web container, this will also include the `jSessionId` in the http header.
6. If we want to create cookies we can do it by

   ```Java
   Cookie c = new Cookie("Sri Rama","1234");
   ```

7. To set the cookie on the http response we can use `response.addCookie(c);`
8. If we want to retrieve the cookies we use

   ```Java
   Cookie[] cookies = request.getCookies();
   ```

We get array of cookies back. then we use `cookies[i].getName();` to retrieve the name of the cookie and `cookies[i].getValue();` to get the value of the cookie. 9. URL rewriting is only helpful when cookies are being disabled in the clients web browser for some reason. It only works with url's not form fields. We append to the url.
`Java
    String url = "targetServlet?sessionId=123";
    response.getWriter().print("<a href='"+url"'>Click Here</a>");
    `
