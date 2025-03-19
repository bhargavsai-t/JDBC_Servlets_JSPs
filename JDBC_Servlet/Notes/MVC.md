# Model View Controller Pattern

1. MVC is a design pattern or a framework that splits the web layer into three parts.
2. **Model**: It represents the current state of the application and does most of the work or business logic. It can call into other classes or connect to a database.
3. **View**: It is responsible for displaying the current model to the end user. It will generate a html output and sends it back to the end user.
4. **Controller**: It acts as the glue between the model and view. It is responsible for selecting appropriate model to serve the appropriate requests. So, when a request come in, the container calls the controller and controller assigns the appropriate model to serve. When the model completes the work and returns the response back to the controller. Now controller will look for the appropriate view to deliver response to the end user.
5. In the servlets and Jsp world a _model_ is represented by _java class_, _view_ is represented by _Jsp_, and we use a _servlet_ to represent a _controller_.

## Advantages of using MVC pattern

1. There are _two_ main advantages by using MVC pattern.
2. **Maintenance**: Since we split the responsibilities across various components. If there is any problem we can easily get an idea to where we need to look at to resolve.
3. **Parallel Development**: Developers can Parallelize developing the application like developers those are are working on generating responses can work on HTML and Css and developers those work on business logic can also work.
