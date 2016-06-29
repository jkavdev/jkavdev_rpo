<%@page import="java.util.List"%>
<%@page import="br.com.jkavdev.caelum.fj21.database.dao.ContatoDao"%>
<%@page import="br.com.jkavdev.caelum.fj21.model.Contato"%>
<%@page import="br.com.jkavdev.caelum.fj21.util.data.DataUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<html>
<head>
<title>Listagem de Contato</title>
</head>
<body>

	<c:import url="../cabecalho.jsp" />

	<h1>Listagem de Contato</h1>

	<jsp:useBean id="dao" class="br.com.jkavdev.caelum.fj21.database.dao.ContatoDao"></jsp:useBean>

	<display:table name="dao.findAll">
		<display:column property="name"/>
		<display:column property="email"/>
		<display:column property="endereco"/>
	</display:table>

	<c:import url="../rodape.jsp" />

</body>
</html>