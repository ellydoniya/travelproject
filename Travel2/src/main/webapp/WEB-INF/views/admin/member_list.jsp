<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<title>Hotel List</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link
	href="http://cdn.jsdelivr.net/webjars/bootstrap/3.3.1/css/bootstrap.min.css"
	rel="stylesheet" media="screen" />
	<script th:src="@{|/js/jquery.js|}"></script>
</head>
<body>

	<div th:include="fragments/header"></div>
	<div class="container">

		<div class="page-header">
			<h1>Users List</h1>
		</div>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Name</th>
					<th>Username</th>
					<th>E-mail</th>
					<th>Role</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tr th:each="user : ${users}">
				<td><span th:text="${user.name}"></span></td>
				<td><a th:href="@{|/users/${user.id}|}"><span
						th:text="${user.username}"></span></a></td>
				<td><span th:text="${user.email}"></span></td>
				<td><span th:text="${user.authority.role}"></span></td>
				<td><a th:href="@{|/users/${user.id}/edit|}"><i
						class="glyphicon glyphicon-pencil"></i></a></td>
				<td><a th:href="@{|/users/${user.id}/remove|}"><i
						class="glyphicon glyphicon-trash"></i></a></td>
			</tr>
		</table>
	</div>
</body>
</html>
