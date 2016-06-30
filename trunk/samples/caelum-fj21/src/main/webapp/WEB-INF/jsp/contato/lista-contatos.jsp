<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@page import="java.util.List"%>
<%@page import="br.com.jkavdev.caelum.fj21.database.dao.ContatoDao"%>
<%@page import="br.com.jkavdev.caelum.fj21.model.Contato"%>

<html>
<head>
<title>Listagem de Contato</title>
</head>
<body>

	<c:import url="../template/cabecalho.jsp" />

	<h1>Listagem de Contato</h1>

	<display:table name="${contatos}" id="contato" class="table table-bordered tableContato">
		<display:column property="nome" />
		<display:column property="email" autolink="true" />
		<display:column property="endereco" />
		<display:column title="Data" sortable="true">
			<fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" />
		</display:column>
		<display:column title="Remover" value="<a href='mvc?logica=RemoveContact&id=${contato.id}'>Remover</a>" />
		<display:column title="Editar" value="<a href='mvc?logica=UpdateContact&id=${contato.id}'>Editar</a>" />
	</display:table>

	<a href="mvc?logica=SaveContact"><span class="badge">Adicionar novo contato</span></a>

	<div class="navbar navbar-default navbar-fixed-bottom">
		<div class="container">
			<p class="navbar-text pull-left">
				<c:import url="../template/rodape.jsp" /> 
				<a href="http://tinyurl.com/tbvalid" target="_blank"> - Agenda de Contatos</a>
			</p>
		</div>
	</div>

</body>
</html>