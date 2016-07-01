<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="/caelum-spring-mvc/resources/css/style.css" />
		<link rel="stylesheet" type="text/css" href="/caelum-spring-mvc/resources/bootstrap/css/bootstrap.css" />
		<script src="/caelum-spring-mvc/resources/bootstrap/js/bootstrap.js" type="text/javascript"></script>
		<title>Formulário de Cadastro de Tarefa</title>
	</head>
	<body>
	
		<form action="adicionaTarefa" method="post">
		
			<h3>Adicionar Tarefas</h3>
		
			<div class="form-group">
			    <label for="tarefa">Example textarea</label>
			    <textarea class="form-control" id="tarefa" rows="5" cols="100"></textarea>
	  		</div>
	  		
	  		<form:errors path="tarefa.descricao" cssStyle="color:red"/>
			
			<input type="submit" class="btn btn-primary" value="Adicionar"/>
		</form>
	
	</body>
</html>