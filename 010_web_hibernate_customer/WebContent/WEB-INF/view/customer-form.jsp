
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>   

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Save Customer</title>
	<link type="text/css"
	      rel="stylesheet"
	      href="${pageContext.request.contextPath}/resources/css/style.css"
	/>

	<link type="text/css"
	      rel="stylesheet"
	      href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"
	/>

</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<form:form action="saveCustomer" modelAttribute="customer" method="POST">
			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td> <form:input path="firstName"/></td>
					</tr>
				</tbody>
			
			</table>
		</form:form>
	</div>
	
	
	
</body>
</html>