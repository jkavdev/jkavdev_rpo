<html>
	<head>
		<title>Bem vindo</title>
	</head>
	<body>
		<h1>Seja Bem-vindo</h1>
	
		<%-- comentário em JSP aqui: nossa primeira página JSP --%>
		
		<% String mensagem = "Bem vindo ao sistema de agenda do FJ-21!"; %>
		<% out.println(mensagem); %>
		<br />
		<% String desenvolvido = "Desenvolvido por (JKAVDEV)"; %>
		<%=desenvolvido%>
	
	</body>
</html>