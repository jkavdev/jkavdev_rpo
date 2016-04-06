<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="br.com.jkavdev.fj21.jdbc.modelo.Contato"%>
<%@page import="java.util.List"%>
<%@page import="br.com.jkavdev.fj21.jdbc.dao.ContatoDao"%>

<html>
<head>
<title>Listagem de Contatos</title>
</head>
<body>

	<!-- instanciando contato dao -->
	<jsp:useBean id="contatoDao" class="br.com.jkavdev.fj21.jdbc.dao.ContatoDao" />

	<table border="1">
		<tr align="center">
			<td>Nome</td>
			<td>Email</td>
			<td>Endereco</td>
			<td>Data de Nascimento</td>
		</tr>
		<c:forEach items="${contatoDao.lista}" var="contato" varStatus="id">
			<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff'}">
				<td>${contato.nome}</td>
				<td>${contato.email}</td>
				<td>${contato.endereco}</td>
				<td>${contato.dataNascimento.time}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>