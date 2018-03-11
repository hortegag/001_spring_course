<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE>
<html>
<head>
	<title>Student Confirmation</title>
</head>
<body>
The student is confrmed: ${student.firstName} ${student.lastName} 
<br><br>

Country: ${student.country} 

<br><br>

Favorite Language: ${student.favoriteLanguage} 
<br><br>

Operating Systems:
<ul>
	<c:forEach var="temp" items="${student.operatingSystems}">
	<li>${temp} </li>
	</c:forEach>
</ul>

<br><br>

</body>
</html>