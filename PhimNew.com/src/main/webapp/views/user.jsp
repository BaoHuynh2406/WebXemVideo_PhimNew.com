<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>User Management</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<style>
body {
	margin: 0;
	padding: 0;
	text-align: center;
	background: #FFFBEB;
}

h1 {
	margin-top: 5%;
	margin-bottom: 2%;
	color: #251749;
}

.div_form {
	width: 40%;
	margin-left: auto;
	margin-right: auto;
	color: #263159;
}

.input-group-text, .input-group mb-3 {
	color: #263159;
}

.div_role {
	display: flex;
}

.div_role>input, .div_role>label {
	margin-left: 0.3rem;
}

.table {
	width: 60%;
	margin-left: auto;
	margin-right: auto;
}

.alert {
	width: 60%;
	margin-left: auto;
	margin-right: auto;
}

a {
	color: #263159;
	margin-left: 0.2rem;
}

.delete {
	color: #DC3535;
}
</style>
</head>
<body>
	<h1>User Manager</h1>
	<div class="alert">
		<c:if test="${not empty message}">
			<div class="alert alert-success">${message}</div>
		</c:if>
		<c:if test="${not empty error}">
			<div class="alert alert-danger">${error}</div>
		</c:if>
	</div>
	<form class="div_form" action="/PhimNew/user/index" method="post">
		<div class="input-group mb-3">
			<span class="input-group-text" id="inputGroup-sizing-default">Username</span>
			<input name="id" type="text" class="form-control" value="${user.id}"
				aria-label="Sizing example input"
				aria-describedby="inputGroup-sizing-default">
		</div>
		<div class="input-group mb-3">
			<span class="input-group-text" id="inputGroup-sizing-default">Password</span>
			<input name="password" type="password" class="form-control"
				value="${user.password}" aria-label="Sizing example input"
				aria-describedby="inputGroup-sizing-default">
		</div>
		<div class="input-group mb-3">
			<span class="input-group-text" id="inputGroup-sizing-default">Fullname</span>
			<input name="fullName" type="text" class="form-control"
				value="${user.fullName}" aria-label="Sizing example input"
				aria-describedby="inputGroup-sizing-default">
		</div>
		<div class="input-group mb-3">
			<span class="input-group-text" id="inputGroup-sizing-default">Email</span>
			<input name="email" type="email" class="form-control"
				value="${user.email}" aria-label="Sizing example input"
				aria-describedby="inputGroup-sizing-default">
		</div>
		<div class="input-group mb-3">
			<span class="input-group-text" id="inputGroup-sizing-default">Birthday</span>
			<input name="" type="date" class="form-control"
				value="" aria-label="Sizing example input"
				aria-describedby="inputGroup-sizing-default">
		</div>
		<div class="div_role mb-2">
			<input type="radio" class="btn-check" name="role" id="admin"
				autocomplete="off" required value="true" ${user.admin?'checked':''}>
			<label class="btn btn-sm btn-outline-secondary" for="admin">Admin</label>

			<input type="radio" class="btn-check" name="role" id="user"
				autocomplete="off" required value="false"
				${!user.admin?'checked':''}> <label
				class="btn btn-sm btn-outline-secondary" for="user">User</label>
		</div>

		<div class="div_role mb-3">
			<input type="radio" class="btn-check" name="gender" id="male"
				autocomplete="off" required value="true" ${user.gender?'checked':''}>
			<label class="btn btn-sm btn-outline-secondary" for="male">Nam</label>

			<input type="radio" class="btn-check" name="gender" id="female"
				autocomplete="off" required value="false"
				${!user.gender?'checked':''}> <label
				class="btn btn-sm btn-outline-secondary" for="female">Nữ</label>
		</div>



		<button formaction="/PhimNew/user/create"
			class="btn btn-outline-success">Create</button>
		<button formaction="/PhimNew/user/update"
			class="btn btn-outline-warning">Update</button>
		<button formaction="/PhimNew/user/delete"
			class="btn btn-outline-danger">Delete</button>
		<button formaction="/PhimNew/user/reset" class="btn btn-outline-info">Reset</button>
	</form>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Password</th>
				<th scope="col">Name</th>
				<th scope="col">Email</th>
				<th scope="col">Gender</th>
				<th scope="col">Role</th>
				<th scope="col">Birthday</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${users}">
				<tr>
					<td>${user.id}</td>
					<td>${user.password}</td>
					<td>${user.fullName}</td>
					<td>${user.email}</td>
					<td>${user.gender ? 'Nam':'Nữ'}</td>
					<td>${user.admin?'Admin':'User'}</td>
					<td>${user.birthday}</td>

					<td><a href="/PhimNew/user/edit/?id=${user.id}"> edit </a> <a
						class="delete" href="/PhimNew/user/delete/?id=${user.id}">
							delete </a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
</body>
</html>