<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista</title>
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
				data-toggle="dropdown">Usuários</button>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="/usuario">Novo</a>
			</div>
		</div>
		<br>

		<c:if test="${not empty msgError}">
			<div class="alert alert-danger">
				<div class="alert alert-danger" role="alert">${msgError}</div>
			</div>
		</c:if>

		<c:if test="${not empty usuarios}">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>#</th>
						<th>Nome</th>
						<th>Usuário</th>
						<th>Gestor</th>
						<th>Setor</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="user" items="${usuarios}">
						<tr>
							<td>${user.id}</td>
							<td>${user.nome}</td>
							<td>${user.login}</td>
							<c:choose>
								<c:when test="${user.gestor}">
									<td>SIM</td>
								</c:when>
								<c:otherwise>
									<td>NÃO</td>
								</c:otherwise>
							</c:choose>
							<td>${user.setor.nome}</td>
							<td><a href="/usuario/${user.id}/excluir"><i
									class="fas fa-trash"></i></a></td>
							<td><a href="/usuario/${user.id}/alterar"><i
									class="fas fa-edit"></i></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		<c:if test="${empty usuarios}">
			<div class="alert alert-warning">
				<strong>Sem registros cadastrados!!</strong>
			</div>
		</c:if>
	</div>
</body>
</html>