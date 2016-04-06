<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<html>
	<body>
		<c:import url="cabecalho.jsp" />
		<!-- action - indica qual endereco deve ser chamado ao submeter -->
		<!-- o formulario, no caso quando clicar no gravar -->
		<form action="adicionaContatos">
			Nome: <input type="text" name="nome"/><br />
			Email: <input type="text" name="email"/><br />
			Endereco: <input type="text" name="endereco"/><br />
			Data de Nascimento: <caelum:campoData id="dataNascimento" /><br />
			
			<input type="submit" value="Gravar" /><br />
		</form>
		<c:import url="rodape.jsp" />
	</body>
</html>