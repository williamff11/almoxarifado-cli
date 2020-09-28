<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>AppGrana</title>
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

		<h3>${operacao}</h3>

		<form action="/usuario" method="post">
			<input type="hidden" name="id" value="${usuario.id}">

			<div class="form-group">
				<label for="usr">Nome:</label> <input type="text"
					class="form-control" name="nome" value="${usuario.nome}">
			</div>

			<div class="form-group">
				<label for="usr">Login:</label> <input type="text"
					class="form-control" name="login" value="${usuario.login}">
			</div>

			<c:if test="${operacao == 'Inclusão'}">
				<div class="form-group">
					<label for="usr">Senha:</label> <input type="password"
						class="form-control" name="senha">
				</div>
			</c:if>
			<div class="form-group">
				<label for="usr">Setor</label> <select name="setor.id"
					class="form-control">
					<c:forEach var="setor" items="${listaSetor}">
						<option value="${setor.id}">${setor.id}-${setor.nome}</option>
					</c:forEach>
				</select>
			</div>

			<button type="submit" class="btn btn-primary">Cadastrar</button>
		</form>

	</div>

</body>
</html>