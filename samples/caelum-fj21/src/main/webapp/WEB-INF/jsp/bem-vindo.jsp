<html>
	<head>
		<title>Bem vindo</title>
	</head>
	<body>
		<h1>Seja Bem-vindo</h1>
	
		<%-- coment�rio em JSP aqui: nossa primeira p�gina JSP --%>
		
		<% String mensagem = "Bem vindo ao sistema de agenda do FJ-21!"; %>
		<% out.println(mensagem); %>
		<br />
		<% String desenvolvido = "Desenvolvido por (JKAVDEV)"; %>
		<%=desenvolvido%>
		
		<br /><br />
		
		<a href="mvc?logica=SaveContactForm"><span class="badge">Adicionar novo contato</span></a><br /><br />
		<a href="mvc?logica=FindAllContacts"><span class="badge">Lista de contatos</span></a>
	
	</body>
</html>