# Java Server Pages (JSP)

## Introduction

1. JSP comes with API (for developers)and Specification (for JSP container creators).
2. JSP runs on the JSP container. It can handle a request, make connections to the database, sends the response back to the client.
3. A JSP can do everything a servlet can do while overcoming the limitations of servlets.
4. JSP separates out the Java and HTML code. Parallel development is possible. Maintenance become very easy.
5. JSPs avoid broiler plate coding that we need not import http classes and implementing methods present in http class.
6. JSP files present in `webapp` folder.

## JSP Elements

There are three types of elements present in JSP

1. **Scripting elements**: To embed java code into a JSP page.
2. **Directives**: Translation time instructions to the container involves importing files, classes, and libraries.
3. **Actions**: Run time instruction to the JSP container.

## JSP lifecycle methods and phases

1. Like servlet JSP has also _three lifecycle methods_ and _six phases_.
2. Life cycle methods are `jspInit()`, `_jspService()`, and `jspDestroy()`.
3. Six phases are translation, compilation, instantiation, initialization, servicing, and destruction.
4. When container calls `jspInit()`, it is initialization.
5. When container calls `_jspService()`, it is servicing.
6. When container calls `jspDestroy()`, it is destruction.
7. When first client request comes in then the JSP is converted into servlet this phase is translation. `hello.jsp -> hello_jsp.java`.
8. Then the translated servlet file is compiled and converted to class file, this phase is compilation. `hello_jsp.java -> hello_jsp.class`
9. The translation and compilation phase happens only once unless the code is modified.

## Implicit Objects

There are nine objects that are available to every JSP page. We need not do anything to do to invoke them. They are implicitly called. These are implicit objects.

| s.no | objectName  | Type                |
| :--- | :---------- | :------------------ |
| 1    | config      | ServletConfig       |
| 2    | request     | httpServletRequest  |
| 3    | response    | httpServletResponse |
| 4    | session     | HttpSession         |
| 5    | out         | JspWriter           |
| 6    | page        | Object              |
| 7    | application | ServletContext      |
| 8    | exception   | Throwable           |
| 9    | pageContext | PageContext         |

## JSP Scripting Elements

These allow to embed Java code directly into the page. There are three types of scripting elements.

1. **Declaration**: It starts and ends with `<%! %>`. Within these we can declare variables, add methods. Everything we put into the declaration level will go as a field level on the translator servlet. We can have any number of declaration blocks in a JSP. Members of the servlet.

   ```Java
           <%!
           int x = 10;
           int y = 20;
           void myMethod(){
               System.out.print("Hello");
           }
           %>
   ```

2. **Expression**: It starts and ends with `<%= %>`. Within this we can put any java expression that evaluates to that value. This expression tag does two things; it evaluates the value which is put into it and it sends the result back to the web client. We can have any number of declaration blocks and goes under the `_jspService()`. After translation it goes under `service()` in servlet.

   ```Java
       <%= a+b; %>
       <%= user.getName() %>
   ```

3. **Scriplet**: It starts and ends with `<% %>`. We can have any number of Java statements in between. Everything we put into scriplet block will go under `_jspService()`. We can have any number of scriplet blocks in a JSP.

   ```Java
        <%
            String num1 = request.getParameter("num1");
            String num2 = request.getParameter("num2");
            int result = num1 + num2;
        %>
   ```
