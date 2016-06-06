<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${contact.name}</title>
</head>
<body>

	<h1>${contact.name}</h1>

	<ul>
		<li>Street: ${address.street}</li>
		<li>${address.city},${address.state},${address.zip}</li>
	</ul>

	<a href="contact?edit&id=${contact.id}">Edit contact</a> |
	<a href="contacts">Back to contact list</a>

</body>
</html>