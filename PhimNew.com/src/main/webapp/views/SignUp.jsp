<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Tạo tài khoản</title>

    <link rel="icon" type="image/x-icon" href="views/src/img/logo12.png">
    <link rel="stylesheet" href="views/src/css/login.css"> 
    <link rel="stylesheet" href="views/src/css/home-page.css">
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css" />
    <!-- Google Fonts Roboto -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" />



</head>

<body>
	<section class="container">
		<div
			class="d-flex flex-wrap align-items-center justify-content-between "
			style="height: 80px;">
			<!-- LOGO -->
			<a href="/"
				class="d-flex align-items-center mb-2 col-12 col-lg-3 mb-lg-0 text-dark text-decoration-none">
				<img src="views/src/img/logo12.png" width="50" height="50"
				alt="logo"> <span class="ms-3 fw-bold fs-5">PhimNew.com
			</span>
			</a>
		</div>
	</section>
	<section style="background-color: #606b84; padding: 20px 0;">
		<div class="container  h-100">
			<div
				class="row d-flex align-items-center justify-content-center h-100">
				<div class="col-sm-0 col-md-4 col-lg-4 col-xl-6">
					<img src="views/src/img/Insurance-amico.svg"
						class="img-fluid img-panner" alt="img" width="500px">
				</div>
				<div
					class="card px-5 py-4 col-sm-12 col-md-9 col-lg-7 col-xl-5 offset-xl-1">

					<form name="frmdk" action="/PhimNew/SignUp" method="post" onsubmit="return validateForm()">
						<h3 class="text-center mb-5">Đăng Ký</h3>
						<div class="alert">
							<c:if test="${not empty message}">
								<div class="alert alert-success">${message}</div>
							</c:if>
							<c:if test="${not empty error}">
								<div class="alert alert-danger">${error}</div>
							</c:if>
						</div>
						<!-- Username input -->
						<div class="form-outline mb-3">
							<div class="input-group">
								<span class="input-group-text" id="basic-addon1"> <i
									class="fas fa-user"></i></span> <input type="text" name="id"
									placeholder="abc123" class="form-control" value="${user.id}" />
							</div>
							<label class="form-label" for="username">Tên đăng nhập <i
								style="color: red;">*</i></label>

						</div>


						<!-- Password input -->
						<div class="form-outline mb-3">
							<div class="input-group">
								<span class="input-group-text" id="basic-addon1"><i
									class="fas fa-lock"></i></span> <input name="password" type="password"
									class="form-control" value="${user.password}" />
							</div>
							<label class="form-label" for="password">Mật khẩu <i
								style="color: red;">*</i></label>

						</div>

						<!-- Password Repat -->
						<div class="form-outline mb-3">
							<div class="input-group">
								<span class="input-group-text" id="basic-addon1"><i
									class="fas fa-redo-alt"></i></span> <input name="Repasss"
									type="password" class="form-control " />
							</div>
							<label class="form-label" for="form1Example23">Nhập lại
								mật khẩu <i style="color: red;">*</i>
							</label>

						</div>

						<!-- Email input -->
						<div class="form-outline mb-3">
							<div class="input-group">
								<span class="input-group-text" id="basic-addon1"> <i
									class="fas fa-envelope"></i></span> <input type="email" name="email"
									required placeholder="abc@123.com" class="form-control"
									value="${user.email}" />
							</div>
							<label class="form-label" for="email">Email:<i
								style="color: red;">*</i></label>

						</div>


						<!-- Full name -->
						<div class="form-outline mb-3">
							<div class="input-group">
								<span class="input-group-text" id="basic-addon1"><i
									class="fas fa-id-badge"></i></span> <input type="text" name="fullName"
									required placeholder="Nguyen Van A" class="form-control"
									value="${user.fullName}" />
							</div>
							<label class="form-label" for="form1Example23">Tên của
								bạn: <i style="color: red;">*</i>
							</label>

						</div>



						<!-- Giới tính -->
						<div class="mb-3">
							<div class="form-check p-0">
								<label class="form-check-label me-5" for="sex">Giới
									tính:</label> <input class="form-check-input" style="float: none;"
									checked="true" type="radio" name="gender" value="true" id="nam"
									${user.gender?'checked':''}> <label
									class="form-check-label me-5" for="nam"> Nam </label> <input
									class="form-check-input" style="float: none;" type="radio"
									name="gender" value="false" id="nu"
									${!user.gender?'checked':''}> <label
									class="form-check-label" for="nu"> Nữ¯ </label>
							</div>
						</div>

						<!-- Ngày sinh -->
						<div class="form-outline mt-4 mb-5">
							<div class="input-group">
								<span class="input-group-text" id="basic-addon1"> <i
									class="fas fa-birthday-cake"></i>
								</span> <input type="date" required name="date" value=""
									class="form-control" />
							</div>
							<label class="form-label" for="form1Example23">Ngày sinh:
								<i style="color: red;">*</i>
							</label>

						</div>

						<!-- Submit button -->
						<button type="submit" name="dangky"
							class="btn btn-primary btn-lg btn-block w-100 mb-4">Đăng
							ký</button>

					</form>
					<span>Đã có tài khoản? <a href="./login">Đăng nhập ngay</a></span>
				</div>
			</div>
		</div>
	</section>
</body>

</html>
<script>
	function validateForm() {
		var id = document.forms["frmdk"]["id"].value;
		var password = document.forms["frmdk"]["password"].value;
		var repass = document.forms["frmdk"]["Repasss"].value;
		var email = document.forms["frmdk"]["email"].value;
		var fullName = document.forms["frmdk"]["fullName"].value;

		if (id.trim() === "" || password.trim() === "" || repass.trim() === ""
				|| email.trim() === "" || fullName.trim() === "") {
			alert("Vui lòng điền đầy đủ thông tin");
			return false;
		}

		if (id.length < 6) {
			alert("Tên đăng nhập phải có ít nhất 6 ký tự");
			return false;
		}
		if (password.length < 6) {
			alert("Mật khẩu phải có ít nhất 6 ký tự");
			return false;
		}

		if (password !== repass) {
			alert("Mật khẩu và mật khẩu nhập lại không khớp");
			return false;
		}

		var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
		if (!emailRegex.test(email)) {
			alert("Định dạng email không hợp lệ");
			return false;
		}

		return true;
	}
</script>
