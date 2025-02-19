# HTTP

1. The http protocol supports several methods using which a web client can access a web server.
2. Two of the popular methods are GET and POST.
3. GET is used by default and meant for fetching the data.
4. POST is used when the data is sent to the server.
5. If we do not mention what method should http use, it will use get as default.
6. Get method has only header field and no body field. On the other hand post has a body field.
7. Get method has a query string that appended to the URL and post appends it to the payload or body.
8. We shall not use get method to send sensitive information as the information is shown in URL bar.
9. We can send sensitive information in post as the data is sent in body of the method.
10. And the get method has a restriction on length which in turn has a restriction of data.
11. The post method has no such restriction.
12. The get method is faster than post method.
13. Finally get is idempotent it means we can use get method any number of times and it does not affect the state of the application.
14. But post is not idempotent as we use post for adding, updating, or deleting the data. So if we execute the post method it will affect the state of application.
15. 