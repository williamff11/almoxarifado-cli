<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WebAlmoxarifado</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
	integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
	crossorigin="anonymous" />
</head>
<body>
	<div class="container">

		<div class="container-fluid" style="margin-top: 80px">
			<c:import url="/WEB-INF/jsp/header.jsp" />
		</div>

		<div class="dropdown">
			<button type="button" class="btn btn-primary dropdown-toggle"
				data-toggle="dropdown">Solicitações</button>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="/solicitacao">Novo</a>
			</div>
		</div>
		<br>

		<c:if test="${not empty msgError}">
			<div class="alert alert-danger">
				<div class="alert alert-danger" role="alert">${msgError}</div>
			</div>
		</c:if>

		<c:if test="${not empty solicitacoes}">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>#</th>
						<th>Solicitante</th>
						<th>Setor</th>
						<th>Produtos</th>
						<th>Data</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="solicitacao" items="${solicitacoes}">
						<tr>
							<td>${solicitacao.id}</td>
							<td>${solicitacao.usuario.nome}</td>
							<td>${solicitacao.usuario.setor.nome}</td>
							<td>${solicitacao.produtos.size()}</td>
							<td>${solicitacao.data}</td>
							<td><a href="/solicitacao/${solicitacao.id}"><i
									class="fab fa-readme"></i></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		<c:if test="${empty solicitacoes}">
			<div class="alert alert-warning">
				<strong>Sem registros cadastrados!!</strong>
			</div>
		</c:if>
	</div>
</body>
</html>