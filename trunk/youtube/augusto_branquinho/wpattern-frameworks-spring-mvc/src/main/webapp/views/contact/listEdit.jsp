<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	
	<head>
		<title>WPattern Spring MVC</title>
	</head>
	
	<body>
		
		<h2>Contacts</h2>
		
		<form:form action="/contact/saveList.html" method="post" modelAttribute="contactForm">
		
			<table>
				<tr>
					<th>Id</th>
					<th>First Name</th>
					<th>Last name</th>
					<th>Email</th>
					<th>Phone</th>
					<th></th>
					<th></th>
				</tr>
				<c:forEach items="${contactForm.contacts}" var="contact" varStatus="status">
					<tr>
						<td><input name="contacts[${status.index}].id" value="${contact.id}"/></td>
						<td><input name="contacts[${status.index}].firstName" value="${contact.firstName}"/></td>
						<td><input name="contacts[${status.index}].lastName" value="${contact.lastName}"/></td>
						<td><input name="contacts[${status.index}].email" value="${contact.email}"/></td>
						<td><input name="contacts[${status.index}].phone" value="${contact.phone}"/></td>
					</tr>
				</c:forEach>
			</table>
			
			<br />
			
			<input type="submit" name="action" value="Save" />
			<input type="submit" name="action" value="Cancel" />
		</form:form>
	</body>
</html>