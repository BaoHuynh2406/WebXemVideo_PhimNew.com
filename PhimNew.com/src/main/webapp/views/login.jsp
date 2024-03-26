<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>

<link rel="icon" type="image/x-icon" href="views/src/img/logo12.png">
<link rel="stylesheet" href="views/src/css/login.css">
<!-- Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.11.2/css/all.css" />
<!-- Google Fonts Roboto -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" />



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

	<section class="vh-100" style="background-color: #606b84;">
		<div class="container  h-100">
			<div
				class="row d-flex align-items-center justify-content-center h-100">

				<div class="col-sm-0 col-md-4 col-lg-4 col-xl-6">
					<img src="views/src/img/Security-pana.svg"
						class="img-fluid img-panner" alt="img">
				</div>

				<div
					class="card px-5 py-4 col-sm-12 col-md-9 col-lg-7 col-xl-5 offset-xl-1">



					<form class="navBar" name="frmdn" action="login" method="post">
						<h3 class="text-center mb-5">Đăng Nhập</h3>
						<!-- Email input -->
						<div class="form-outline mb-4">
							<div class="input-group">
								<span class="input-group-text" id="basic-addon1"> <i
									class="fas fa-user"></i></span> <input type="text" required
									name="username" placeholder="Tên đăng nhập của bạn"
									class="form-control form-control-lg" />
							</div>
							<label class="form-label" for="form1Example13">Tên đăng
								nhập</label>

						</div>

						<!-- Password input -->
						<div class="form-outline mb-4">
							<div class="input-group">
								<span class="input-group-text" id="basic-addon1"><i
									class="fas fa-lock"></i></span> <input type="password"
									placeholder="Mật khẩu của bạn" required name="password"
									class="form-control form-control-lg" />
							</div>
							<label class="form-label" for="form1Example23">Mật khẩu</label>
						</div>

						<div
							class="d-flex justify-content-between align-items-center mb-4">
							<!-- Checkbox -->
							<div class="form-check">
								<input class="form-check-input" name="remember" type="checkbox"
									value="" id="form1Example3" checked /> <label
									class="form-check-label" for="form1Example3"> Lưu mật
									khẩu </label>
							</div>
							<a href="#!">Quên mật khẩu?</a>
						</div>

						<!-- Submit button -->
						<p class="text-center" style="color: red;">${message }</p>
						<button type="submit"
							class="btn btn-primary btn-lg btn-block w-100">Đăng nhập</button>
					</form>
					<div class="divider d-flex align-items-center my-4">
						<p class="text-center fw-bold mx-3 mb-0 text-muted w-100">Hoặc</p>
					</div>

					<div class="row justify-content-around mb-4">

						<a class="col-5  btn btn-primary  btn-block"
							style="background-color: #ff2a00;" href="index.html"
							role="button"> <i class="fab fa-google me-2"></i></i>Google
						</a>

					</div>

					<span>Chưa có tài khoản? <a href="/SignUp">đăng kí ngay</a></span>


				</div>
			</div>
		</div>
	</section>
</body>

</html>