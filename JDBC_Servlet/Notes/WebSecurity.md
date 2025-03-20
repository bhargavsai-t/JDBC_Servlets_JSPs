# Web Security

We can set the roles and assign those roles to users for security. We have to configure user-role and user in `tomcat-users.xml`. Later we need to specify it in `web.xml` of project folder.

Here is how it looks `tomcat-users.xml`

```xml
<tomcat-users>
<role rolename="myUserRole"/>
<user username="myUser" password="myPassword" roles="myUserRole"/>
</tomcat-users>
```

And here is how it looks in `web.xml`

```xml
<web-app>

<security-constraint>

<web-resource-collection>
<web-resource-name>My Web App</web-resource-name>
<url-pattern>/*</url-pattern>
</web-resource-collection>
<!-- Here /* means applicable to all files. If we want for a specific file we have to mention name-->

<auth-constraint>
<role-name>myUserRole</role-name>
</auth-constraint>

</security-constraint>

<login-config>
<auth-method>BASIC</auth-method>
<realm-name>FILE</realm-name>
</login-config>

<!--Telling browser how to authenticate. Here it just pop up ask for credentials. If we use FORM, we have to create a form and give it to browser and an additional error page if authentication fails -->
<!--We have to specify in form action as "j_security_check" and name of user field is "j_username" and password is "j_password" -->
<login-config>
<auth-method>FORM</auth-method>
</realm-name>FILE</realm-name>
<form-login-config>
<form-login-page>/login.jsp</form-login-page>
<form-error-page>/error.jsp</form-error-page>
</form-login-config>
</login-config>
<web-app>
```
