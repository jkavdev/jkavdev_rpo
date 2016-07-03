<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>" />
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>" />
		<script src="resources/bootstrap/js/bootstrap.js" type="text/javascript"></script>
		<title>Formulário de Cadastro de Tarefa</title>
	</head>
	<body>
	
		<h3>Nova Tarefa</h3>
	
		<form action="adicionaTarefa" method="post" class="formTarefa">
		
			<form:errors path="tarefa.descricao" cssStyle="color:red"/>
			
			<div class="form-group panelTarefa">
			    <label for="tarefa">Cadastro de Tarefas</label>
			    <textarea name="descricao" class="form-control textTarefa" id="tarefa" rows="5" cols="100"></textarea>
	  		</div>
			
			<input type="submit" class="btn btn-primary" value="Adicionar"/>
		</form>
	
	</body>
</html>