<%@page import="java.util.List"%>
<%@page import="br.com.jkavdev.caelum.fj21.database.dao.ContatoDao"%>
<%@page import="br.com.jkavdev.caelum.fj21.model.Contato"%>
<%@page import="br.com.jkavdev.caelum.fj21.util.data.DataUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Listagem de Contato</title>
</head>
<body>
	<h1>Listagem de Contato</h1>

	<jsp:useBean id="dao" class="br.com.jkavdev.caelum.fj21.database.dao.ContatoDao"></jsp:useBean>

	<table style="border: 1px solid black;">
		<tr>
			<td>Nome</td>
			<td>E-mail</td>
			<td>Endere�o</td>
			<td>Data de Nascimento</td>
		</tr>
		
		<c:forEach var="contato" items="${dao.findAll() }" varStatus="id">
			<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff' }">
				<td>${id.count}</td>
				<td>${contato.nome }</td>
				<td>${contato.email }</td>
				<td>${contato.endereco }</td>
				<td>${contato.dataNascimento }</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>