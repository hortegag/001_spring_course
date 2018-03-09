<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE>
<html>
<body>
 <form:form action="processForm" modelAttribute="student">
 First Name: <form:input path="firstName"/>

 <br><br>
 Last Name: <form:input path="lastName"></form:input>
  <br><br>
 Country:
 <form:select path="country">
 	<form:options items="${student.countryOptions}"/>
 </form:select>
 
 <br><br>
 Favorite Language:
 Java <form:radiobutton path="favoriteLanguage" value="Java"/>
 
 Python <form:radiobutton path="favoriteLanguage" value="Python"/>
 
 Groovy <form:radiobutton path="favoriteLanguage" value="Groovy"/>
 
 
 <br><br>
 
 
 <input type="submit" value="Submit">
 
  </form:form>
</body>
</html>