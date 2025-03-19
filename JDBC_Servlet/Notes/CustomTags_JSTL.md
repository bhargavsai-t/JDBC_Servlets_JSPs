# Custom Tags and JSTL

## Custom Tags

1. When the inbuilt jsp actions or tags are not enough to perform for business operations in a jsp page we develop our own tags are called custom tags or custom actions.
2. It is a _two_ step process.
   - Create the _tag handler_ class.
   - Create the _tag library descriptor_ file. It is _xml_ file. This file helps pass in some properties to the tag and mapping the tag. The container will read this file and get to know which tag in jsp corresponds to which tag handler class.
3. For creating custom tag we need to implement `javax.servlet.jsp.tagext.Tag` or we simply extend `javax.servlet.jsp.tagext.TagSupport` which implements Tag class. Tag Support is a helper class. Instead of implementing tag interface and implementing all the methods we simply extend tag support class and implement only the methods we want.
4. Life cycle methods are `setPageContext()`, `doStartTag()`, `doEndTag()`, and `release()`.
5. The class that extends Tag Support class will get all the elements of Jsp like out, using page context. we can use them in classes.
   eg: `pageContext.getRequest();`, `pageContext.getOut();`, and so on.
6. The root element of a tld file is `<taglib></taglib>`. We can have multiple tags.

   ```Java
   <?xml version="1.1" encoding="UTF-8"?>
   <taglib>
   <libversion>2.0</libversion>
   <jspversion>2.0</jspversion>
   <shortname>userinformation</shortname>
   <info>This displays user information</info>
   <url>https://srirama.com</url>
   <tag>
   <name>displayUser</name>
   <tag-class>taghandler.TagHandler</tag-class>
   <info>Displays User Information</info>
   </tag>
   </taglib>
   ```

7. We can have multiple tags in a tld file.
8. We need to use these. The prefix in taglib descriptor is used to load tag. `displayUser` is the name of the tag. So the container will load the class that is named under it.

   ````Java
           <%@ taglib prefix="srirama" uri="http://srirama.com"%>
           <srirama:displayUser />
       ```
   ````

## Java Server page Standard Tag Library

1. These are set of predefined tags from oracle.
2. We can do several things without writing single line of code in jsp page.
3. The first step in using this tags is including 2 jar files i.e., `standard.jar` and `jstl.jar`.
4. We need to include this at the top of Jsp `<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>`
5. Some tags in JSTL:

   1. `<c:out value="${10+9}"/>`: This `c:out` tag takes the value and gives iy back to the web browser.
   2. `<c:set var="score" scope="session" value="${80}"></c:set>`: We are setting a variable score with value 80 with the scope of session. The scope could be _session_, _application_, _request_, _context_. This works as a shortcut to `request.setAttribute()`.
   3. `<c:remove var="score"/>`: It by default searches all the scopes and removes the attribute.It is used instead `scope.removeAttribute()`.
   4. `<c:if/>`: Similar to _if_ in java, it checks the condition an renders the output based on expression evaluation.

      ```Java
      <c:if test="${score>=80 }">
      <p>Hello</p>
      </c:if>
      ```

   5. `c:choose></c:choose>`: This is similar to _switch_ in java.

      ```Java
       <c:choose>
      <c:when test="${score>80}"><p>O Grade</p></c:when>
      <c:when test="${score>=70}"><p>A+ Grade</p></c:when>
      <c:when test="${score>50}"><p>A Grade</p></c:when>
      <c:otherwise><p>Fail</p></c:otherwise>
       </c:choose>
      ```

   6. `<c:forEach>`: Similar to for loop we can loop through a list iterate over a array.

      ```Java
      <c:forEach var="i" begin="1" end="5">
      <c:out value="${i}"/><br/>
      </c:forEach>
      /// 2nd Loop
      <%
       List<String> studentNames = new ArrayList<>();
      studentNames.add("Sri Rama");
      studentNames.add("Sita Rama");
      studentNames.add("Laxmana Rama");
      studentNames.add("Hanumath Rama");
      request.setAttribute("studentNames", studentNames);
      %>
      <c:forEach var="studentName" items="${studentNames}">
      <c:out value="${studentName}"/><br/>
      </c:forEach>
      ```

## JSTL Formatting

1. For formatting, we have to use this directive `<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>`.
2. Tags in formatting are

   1. `<fmt:parseNumber/>`: To parse a number we use this.

      ```Java
        <c:set var="accountBalance" value="12345"/>
        <fmt:parseNumber var="i" type="number" value="${accountBalance}"/>
        AccountBalance: <c:out value="${i}"/>
      ```

   2. `fmt:formatNumber>`: This used to format the number. We can specify type. If the type is currency then it will display a dollar symbol. We can also specify the right side of the number using `maxFractionDigits="2"`. It rounds of to 2 decimal points. To control left side digits we use `maxIntegerDigits=""`.We can specify type as percent. It displays a percentage symbol.At last we can specify type as pattern.

      ```Java
         Formatted Number: <fmt:formatNumber value="${accountBalance}" type="currency" /><br/>
         Formatted Number: <fmt:formatNumber value="${accountBalance}" type="number" maxFractionDigits="2"/><br/>
         Formatted Number: <fmt:formatNumber value="${accountBalance}" type="number" maxIntegerDigits="2"/><br/>
         Formatted Number: <fmt:formatNumber value="${accountBalance}" type="percent"/><br/>
      ```

   3. `<fmt:parseDate>`: This is used to parse a string into date.

      ```Java
      <c:set var="myDate" value="12-07-2019"/>
      <fmt:parseDate var="parseDate" value="${myDate}" pattern="dd-mm-yyyy"/>
      ParseDate: <c:out value="${parseDate}"/>
      ```
