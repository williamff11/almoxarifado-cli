<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>WebAlmoxarifado</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">

		<div class="container-fluid" style="margin-top: 80px">
			<c:import url="/WEB-INF/jsp/header.jsp" />
		</div>

		<h3>Nova Solicitação</h3>

		<form action="/solicitacao" method="post">
			<input type="hidden" name="usuario" value="${user.id}">


			<c:if test="${operacao == 'consulta'}">
				<div class="form-group">
					<label for="usr">Solicitante:</label> <input type="text"
						class="form-control" name="solicitante"
						value="${solicitacao.usuario.nome}">
				</div>
			</c:if>

			<div class="form-group">
				<label for="usr">Data Devolução</label> <input type="date" name="data"
					value="${solicitacao.data}">
			</div>

			<c:if test="${operacao != 'consulta'}">
				<div class="form-group">
					<label for="usr">Produtos:</label>
					<c:if test="${not empty produtos}">
						<div class="form-check">
							<label class="form-check-label"> <c:forEach var="p"
									items="${produtos}">
									<input type="checkbox" class="form-check-input" name="produtos"
										value="${p.id}"> ${p.descricao}<br>
								</c:forEach>
							</label>
						</div>
					</c:if>
				</div>
				<c:if test="${empty produtos}">
					<label for="usr">Nenhum produto cadastrado!</label>
				</c:if>
			</c:if>
			<button type="submit" class="btn btn-primary">Cadastrar</button>
		</form>

	</div>

</body>
</html>