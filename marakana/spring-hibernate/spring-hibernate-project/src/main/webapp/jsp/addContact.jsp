<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Contacts</title>
</head>
<body>

	<h1>Add Contacts</h1>

	<form method="post" action="contact?add">
		<input type="hidden" name="add" />
		
		<ul>
			<li>Name: <input type="text" name="name" /></li>
			<li>Street: <input type="text" name="street" /></li>
			<li>City: <input type="text" name="city" /></li>
			<li>State: <input type="text" name="state" /></li>
			<li>Zip: <input type="text" name="zip" /></li>
		</ul>
		
		<input type="submit" value="Add"/>
	</form>
	
	<a href="contacts">Back to contact list</a>

</body>
</html>