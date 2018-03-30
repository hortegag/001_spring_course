<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page Spring Security</title>
</head>
<body>
<p>Home page test</p>

	<hr>
	<p>
		User: <security:authentication property="principal.username"/>
		<br>
		<br>
		Role(s): <security:authentication property="principal.authorities"/>
	</p>
	
	<hr>
	
	<p>
		<a href="${pageContext.request.contextPath}/leaders" >Leadership Meeting</a>
		Only for managers
	</p>
	
	<p>
		<a href="${pageContext.request.contextPath}/systems" >Systems Options</a>
		Only for Admins
	</p>

	<!-- Add logout button -->
	<form:form action="${pageContext.request.contextPath}/logout"
			   method="POST">
		
		<input type="submit" value="Logout">
	
	</form:form>
	
	
</body>
</html>