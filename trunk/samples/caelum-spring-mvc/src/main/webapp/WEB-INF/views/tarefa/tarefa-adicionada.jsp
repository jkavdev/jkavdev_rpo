<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link type="text/css" href="<c:url value="/resources/css/style.css"/>" rel="stylesheet" />
		<link type="text/css" href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>" rel="stylesheet" />
		<script src="resources/bootstrap/js/bootstrap.js" type="text/javascript"></script>
		<title>Tarefa adicionada</title>
	</head>
	<body>
		
		<div class="alert alert-success" role="alert">
			<h1>Tarefa ${param.nome} adicionada com Sucesso</h1>
		</div>
		
		<a href="novaTarefa"><span class="badge">Adicionar nova tarefa</span></a>
		<a href="mvc?logica=FindAllContacts"><span class="badge">Lista de Tarefas</span></a>
		
	</body>
</html>