<%@page import="br.com.jkavdev.fj21.jdbc.modelo.Contato"%>
<%@page import="java.util.List"%>
<%@page import="br.com.jkavdev.fj21.jdbc.dao.ContatoDao"%>
<% taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Listagem de Contatos</title>
</head>
<body>

	<jsp:useBean id="dao" class="br.com.caelum.agenda.dao.ContatoDao"></jsp:useBean>

	<table>
		<%
			ContatoDao contatoDao = new ContatoDao();
			List<Contato> contatos = contatoDao.getLista();

			for (Contato contato : contatos) {
		%>
		<tr>
			<td><%= contato.getNome()%></td>
			<td><%= contato.getEmail()%></td>
			<td><%= contato.getEndereco()%></td>
			<td><%= contato.getDataNascimento().getTime() %></td>
		</tr>
		<%
			}
		%>
	</table>

</body>
</html>