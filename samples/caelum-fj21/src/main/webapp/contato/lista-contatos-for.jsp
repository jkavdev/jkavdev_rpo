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
	
	<table style="border: 1px solid black;">
		<tr>
			<td>Nome</td>
			<td>E-mail</td>
			<td>Endereço</td>
			<td>Data de Nascimento</td>
		</tr>
		
		<c:forEach var="contato" items="${dao.getFindAll() }" varStatus="id" >
				<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff' }">
					<td>${id.count}</td>
					<td>${contato.nome }</td>
					<td>${contato.email }</td>
					<td>${contato.endereco }</td>
					<td>
						<fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" />
					</td>
					<td>
						<a href="../mvc?logica=RemoveContact&id=${contato.id}">Remover</a>
					</td>
				</tr>
			</c:forEach>
		
		</table>

	<c:import url="../rodape.jsp" />

</body>
</html>