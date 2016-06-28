<%@page import="java.util.List"%>
<%@page import="br.com.jkavdev.caelum.fj21.database.dao.ContatoDao"%>
<%@page import="br.com.jkavdev.caelum.fj21.model.Contato"%>
<%@page import="br.com.jkavdev.caelum.fj21.util.data.DataUtil"%>
<html>
<head>
<title>Listagem de Contato</title>
</head>
<body>
	<h1>Listagem de Contato</h1>

	<table style="border: 1px solid black;">
		<tr>
			<td>Nome</td>
			<td>E-mail</td>
			<td>Endereço</td>
			<td>Data de Nascimento</td>
		</tr>
		<%
			ContatoDao contatoDao = new ContatoDao();
			List<Contato> contatos = contatoDao.findAll();
			
			for (Contato contato : contatos) {
		%>
		<tr>
			<td><%=contato.getNome()%></td>
			<td><%=contato.getEmail()%></td>
			<td><%=contato.getEndereco()%></td>
			<td><%=DataUtil.formataData(contato.getDataNascimento())%></td>
		</tr>

		<%
			}
		%>
	</table>

</body>
</html>