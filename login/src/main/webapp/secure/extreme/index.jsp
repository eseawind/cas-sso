<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>

<html>
<body>
<h1>VERY Secure Page</h1>
This is a protected page. You can only see me if you are a supervisor.

<authz:authorize access="hasRole('ROLE_ADMIN')">
  <h1> You have "ROLE_SUPERVISOR" (this text is surrounded by &lt;authz:authorize&gt; tags). </h1>
</authz:authorize>

<p><a href="../../">Home</a>
<p><a href="../../secureLogout">Logout</a>
</body>
</html>