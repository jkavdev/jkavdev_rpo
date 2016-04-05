<html>
	<head>
		<title>Bem Vindo</title>
	</head>
	<body>
		<%--comentario em JSP aqui - nossa primeira pagina jsp --%>
		
		<%
			String mensagem = "Bem Vindo ao Sistema de Agenda do fj21";
		%>
		<% out.println(mensagem); %>
		
		<br />
		
		<%
			String desenvolvido = "Desenvolvido por (Jhonatan)";
		%>
		<%= desenvolvido %>
		
		<br />
		
		<%
			System.out.println("Tudo foi Executado!");
		%>
		
	</body>
</html>