<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum"%>
<html>

<head>
<title>Cadastro de Contato</title>
</head>

<c:import url="../template/cabecalho.jsp" />

<body>

	<div class="container">
		<br>
		<div class='row'>
			<div class="col-sm-offset-2 col-md-8">
				<h1 class="text-center">Novo Contato</h1>
				<form class="form-horizontal" method="post" action="mvc?logica=SaveContact" id="formulario">
					<div id="mensagem" class=""></div>
					<div class="form-group">
						<label for="nome" class="col-sm-2 control-label">Nome </label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="nome" name="nome" placeholder="Informe seu Nome" required>
						</div>
					</div>
					<div class="form-group">
						<label for="endereco" class="col-sm-2 control-label">Endereço
						</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="endereco" name="endereco" placeholder="Informe o Endereço" required>
						</div>
					</div>
					<div class="form-group">
						<label for="email" class="col-sm-2 control-label">E-mail </label>
						<div class="col-sm-10">
							<input type="email" class="form-control" id="email" name="email" placeholder="Informe seu E-mail" required>
						</div>
					</div>
					<div class="form-group">
						<label for="dataNascimento" class="col-sm-2 control-label">Data de Nascimento</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="dataNascimento" placeholder="Data de Nascimento">
							<caelum:campoData id="dataNascimento"  />
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="submit" class="btn btn-primary" name="enviar" value="Adicionar Contato">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<c:import url="../template/rodape.jsp" />

</body>
</html>