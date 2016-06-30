<html>
	<head>
	<title>Contato Adicionado=</title>
	</head>
	<body>
		<c:import url="../template/cabecalho.jsp" />
		
		<div class="alert alert-success" role="alert">
			<h1>Contato ${param.nome } adicionado com Sucesso</h1>
		</div>
		
		<a href="mvc?logica=SaveContactForm"><span class="badge">Adicionar novo contato</span></a>
		<a href="mvc?logica=FindAllContacts"><span class="badge">Lista de contatos</span></a>
		
	</body>
</html>