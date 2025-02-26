# Servlet Listeners

1. Servlet Listeners enable our applications to react to certain events that happen in the web browser so our web application will take appropriate action and handle it.
2. These events could be request creation and destruction, when a user request comes in a user session begin created or destroyed, a web application being loaded or unloaded from the container which could be the context level events. And finally we can even handle asynchronous events like on complete, on start async etc..
3. Servlet Listeners are used to handle these events and they are used to perform certain tasks when these events triggered.
4. To create a listener we will implement a listener interface.
5. Once we implement the listener and override the methods we need to tell the container about this listener. We do that using the annotation. We simply mark the class with `@WebListener` annotation or we configure this in the `web.xml` file using `<listener></listener>` with `<listener-class></listener-class>`. So when the container starts it will scan through the classes and see if any of the classes are marked with it.
6. Once we do that the container will automatically detect this listener and will call the methods when the events occur.
