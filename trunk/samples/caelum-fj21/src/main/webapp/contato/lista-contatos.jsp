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

	<c:import url="../cabecalho.jsp" />

	<h1>Listagem de Contato</h1>

	<jsp:useBean id="dao" class="br.com.jkavdev.caelum.fj21.database.dao.ContatoDao"></jsp:useBean>

	<display:table name="${dao.findAll}" id="contato" class="table table-bordered tableContato">
		<display:column property="nome" />
		<display:column property="email" autolink="true" />
		<display:column property="endereco" />
		<display:column title="Data" sortable="true">
			<fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" />
		</display:column>
		<display:column title="Ações" value="<a href='mvc?logica=RemoveContact&id=${contato.id}'>Remover</a>" />
	</display:table>

	<c:import url="../rodape.jsp" />

</body>
</html>