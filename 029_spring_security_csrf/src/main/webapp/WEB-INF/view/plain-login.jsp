<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Custom Login Page</title>
	<style>
		.fail{
			color: red
		}
	</style>
</head>
<body>
<p>Home page test</p>
<h3>Custom Login Form</h3>
	<form:form action="${pageContext.request.contextPath}/authenticateTheUser"
	           method="POST">
	
		<c:if test="${param.error != null}">
			<i class="fail">You entered an invalid username/password</i>
		</c:if>
		
		<p>
			User Name: <input type="text" name="username"/>
		</p>
		<p>
			Password: <input type="password" name="password"/>
		</p>
		
		<input type="submit" value="Login"/>
	</form:form>
</body>
</html>