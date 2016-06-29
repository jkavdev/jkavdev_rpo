<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<html>

	<head>
		<title>Cadastro de Contato</title>
	</head>
	
	<c:import url="../cabecalho.jsp" />
	
	<body>
		<h1>Novo Contato</h1>
		
		<form action="AdicionaContato" method="post" class="form-horizontal">
			Nome: <input type="text" name="nome"/> <br />
			E-mail: <input type="text" name="email"/> <br />
			Endereço: <input type="text" name="endereco"/> <br />
			Data de Nascimento: <caelum:campoData id="dataNascimento" /> <br />
			
			<input type="submit" value="Adicionar Contato" class="btn btn-primary"/>
		</form>
		
		<c:import url="../rodape.jsp" />
		
	</body>
</html>