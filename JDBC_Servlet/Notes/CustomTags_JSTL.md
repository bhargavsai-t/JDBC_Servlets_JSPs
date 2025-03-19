# Custom Tags and JSTL

## Custom Tags

1.  When the inbuilt jsp actions or tags are not enough to perform for business operations in a jsp page we develop our own tags are called custom tags or custom actions.
2.  It is a _two_ step process.
    - Create the _tag handler_ class.
    - Create the _tag library descriptor_ file. It is _xml_ file. This file helps pass in some properties to the tag and mapping the tag. The container will read this file and get to know which tag in jsp corresponds to which tag handler class.
3.  For creating custom tag we need to implement `javax.servlet.jsp.tagext.Tag` or we simply extend `javax.servlet.jsp.tagext.TagSupport` which implements Tag class. Tag Support is a helper class. Instead of implementing tag interface and implementing all the methods we simply extend tag support class and implement only the methods we want.
4.  Life cycle methods are `setPageContext()`, `doStartTag()`, `doEndTag()`, and `release()`.
5.  The class that extends Tag Support class will get all the elements of Jsp like out, using page context. we can use them in classes.
    eg: `pageContext.getRequest();`, `pageContext.getOut();`, and so on.
6.  The root element of a tld file is `<taglib></taglib>`. We can have multiple tags.

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

    ```Java
            <%@ taglib prefix="srirama" uri="http://srirama.com"%>
            <srirama:displayUser />
        ```
