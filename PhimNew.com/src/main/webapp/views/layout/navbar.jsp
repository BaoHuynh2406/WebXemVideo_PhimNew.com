<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!-- NAV -->
 <ul class="nav col-12 col-lg-10 fw-bold">
    <li><a href="#" class="nav-link link-dark selected">Trang chủ</a></li>
    <li><a href="Course.html" class="nav-link link-dark">Yêu thích</a></li>
    <li><a href="/PhimNew/admin" class="nav-link link-dark">Quản lý</a></li>
    <li class="dropdown">
        <a class="nav-link link-dark dropdown-toggle" href="#" role="button"
            data-bs-toggle="dropdown" aria-expanded="false">
            Trợ giúp
        </a>
        <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="#">Facebook</a></li>
            <li><a class="dropdown-item" href="#">Github</a></li>
            <li><a class="dropdown-item" href="#">Mail</a></li>

            <li>
                <hr class="dropdown-divider">
            </li>
            <li><a class="dropdown-item" href="#">Phản hồi</a></li>
        </ul>
    </li>
    <!-- SEARCH -->
    <form class="d-flex align-items-center justify-content-center" >
        <div class="input-group">
            <input ng-model="nd" type="text" class="form-control" placeholder="Tìm kiếm...">
            <div class="input-group-append"><button ng-click="timkiem()" class="btn btn-primary"><i
                        class="bi bi-search"></i></button></div>
        </div>
    </form>
</ul>



<!-- DROPDOWN -->
<div class="col-12 col-lg-2 dropdown text-end text-center">
    <a href="#" class="d-block link-dark text-decoration-none dropdown-toggle" id="dropdownUser1"
        data-bs-toggle="dropdown" aria-expanded="false">
        <img src="views/src/img/person-circle.svg" alt="mdo" width="32" height="32" class="rounded-circle">
        <span class="ms-1 fw-bold fs-7">
		 ${user.fullName}
		</span>
    </a>
    <ul class="dropdown-menu text-small" aria-labelledby="dropdownUser1">
        <li><a class="dropdown-item" href="#">Cài đặt</a></li>
        <li><a class="dropdown-item" href="#">Tài khoản</a></li>
        <li><a class="dropdown-item" href="#!/doipass"> Đổi mật khẩu </a></li>
        <li>
            <hr class="dropdown-divider">
        </li>
        <li><a class="dropdown-item" href="./login">Đăng xuất</a></li>
    </ul>
</div>