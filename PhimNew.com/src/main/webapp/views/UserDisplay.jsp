<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fm" %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<title>Users List</title>
</head>

<body>
	<div class="container mt-5">
		<h1 class="text-center mb-4">User List</h1>
		<div class="d-flex justify-content-center mb-4">
			<a  href="./UserList?action=AddOrEdit" type="button" class="btn btn-success">Add Users</a>
		</div>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Username</th>
					<th scope="col">Password</th>
					<th scope="col">Full Name</th>
					<th scope="col">Email</th>
					<th scope="col">Birthday</th>
					<th scope="col">Gender</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user"  items="${LIST_USER }">
					<tr >
						<th scope="row">#</th>
						<td>${user.userName }</td>
						<td>${user.password }</td>
						<td>${user.fullName }</td>
						<td>${user.email }</td>
						<td>${user.gender ? "Nam" : "Nữ" }</td>
						<td><fm:formatDate value="${user.date }" pattern="dd/MM/yyyy"/> </td>
						<td>
							<a
							href="./UserList?action=AddOrEdit&username=${user.userName}"
							class="btn btn-primary btn-sm btn-action"> <i
								class="fas fa-edit"></i> Edit </a> 
							<a
								href="./UserList?action=Delete&username=<c:out value='${user.userName}'/>"
								class="btn btn-danger btn-sm btn-action ml-1"> <i
									class="fas fa-trash-alt"></i> Delete
							</a>
						</td>
					</tr>
				</c:forEach>

				<!-- Add more rows here -->
			</tbody>
		</table>

	</div>
</body>

</html>