<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<%@page import="br.com.jkavdev.fj21.jdbc.modelo.Contato"%>
<%@page import="java.util.List"%>
<%@page import="br.com.jkavdev.fj21.jdbc.dao.ContatoDao"%>

<html>
<head>
<title>Listagem de Contatos</title>
</head>
<body>
	<c:import url="cabecalho.jsp" />

	<!-- instanciando contato dao -->
	<jsp:useBean id="contatoDao" class="br.com.jkavdev.fj21.jdbc.dao.ContatoDao" />

	<!-- usando displaytag  -->
	<display:table name="${contatoDao.lista}" id="contato">
			<display:column property="nome" />
			<display:column property="email" autolink="true"/>
			<display:column property="endereco"/>
			<display:column title="Data" sortable="true">
		        <fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" />
			</display:column>
		</display:table>

	<c:import url="rodape.jsp" />

</body>
</html>