<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum"%>
<html>

<head>
<title>Cadastro de Contato</title>
</head>

<c:import url="../cabecalho.jsp" />

<body>

	<div class="panel panel-default">
		<div class="panel-heading">
			<h2 class="panel-title">Novo Contato</h2>
		</div>
		<div class="panel-body">
		
			<form action="AdicionaContato" method="post" class="form-horizontal">
			
				<div class="form-group">
					<label for="nome" class="col-sm-2 control-label">Nome</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="nome" name="nome" placeholder="Nome" >
					</div>
				</div>
				
				<div class="form-group">
					<label for="endereco" class="col-sm-2 control-label">Endereço</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="endereco" name="endereco" placeholder="Endereço" >
					</div>
				</div>
				
				<div class="form-group">
					<label for="email" class="col-sm-2 control-label">E-mail</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="email" name="email" placeholder="E-mail" >
					</div>
				</div>
				
				<div class="form-group">
					<label for="dataNascimento" class="col-sm-2 control-label">Data de Nascimento</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="dataNascimento" placeholder="Data de Nascimento">
						<caelum:campoData id="dataNascimento"  />
					</div>				
				</div>
				
				<input type="submit" value="Adicionar Contato" class="btn btn-primary" />
				
			</form>
		</div>
	</div>

	<c:import url="../rodape.jsp" />

</body>
</html>