<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello World</title>
</head>
<body>
	
	<!-- recebendo lista e apresentando resultado, recebido pela requisicao -->
	<c:forEach var="name" items="${names}">
		<h1>Hello , ${name}!</h1>	
	</c:forEach>
	
</body>
</html>