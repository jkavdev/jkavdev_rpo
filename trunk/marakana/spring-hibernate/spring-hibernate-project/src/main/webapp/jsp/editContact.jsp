<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Contacts</title>
</head>
<body>

	<h1>Edit Contacts</h1>

	<form method="post" action="contact">
		<input type="hidden" name="edit" />
		<input type="hidden" name="id" value="${contact.id}"/>
		
		<ul>
			<li>Name: <input type="text" name="name" value="${contact.name}" /></li>
			<li>Street: <input type="text" name="street" value="${address.street}" /></li>
			<li>City: <input type="text" name="city" value="${address.city}" /></li>
			<li>State: <input type="text" name="state" value="${address.state}" /></li>
			<li>Zip: <input type="text" name="zip" value="${address.zip}" /></li>
		</ul>
		
		<input type="submit" value="Edit"/>
	</form>
	
	<a href="contacts">Back to contact list</a>

</body>
</html>