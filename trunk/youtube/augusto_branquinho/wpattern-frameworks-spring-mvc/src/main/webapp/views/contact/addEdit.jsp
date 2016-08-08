<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	
	<head>
		<title>WPattern Spring MVC</title>
	</head>
	
	<body>
		
		<c:choose >
			<c:when test="${contact.id == null}"><h2>Add Contact</h2></c:when>
			<c:when test="${contact.id != null}"><h2>Edit Contact</h2></c:when>
		</c:choose>
		
		<form:form action="/contact/save.html" method="post" modelAttribute="contact">
		
			<input name="id" value="${contact.id}" hidden="true"/>
			<label>First Name: </label><input name="firstName" value="${contact.firstName}"/>
			<label>Last Name: </label><input name="lastName" value="${contact.lastName}"/>
			<label>Email: </label><input name="email" value="${contact.email}"/>
			<label>Phone: </label><input name="phone" value="${contact.phone}"/>
			
			<br />
			
			<input type="submit" name="action" value="Add" />
			<input type="submit" name="action" value="Cancel" />
		</form:form>
	</body>
</html>