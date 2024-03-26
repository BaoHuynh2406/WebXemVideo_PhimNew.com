<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Item -->
<div class="col-sm-12 col-md-6 col-lg-4 mb-5">
	<div class="card card-custom l-bg-cherry px-0">
		<img src="views/src/img/${param.img}" class="card-img-top" alt="...">
		<div class="card-body" style="height: 200px; overflow-y: hidden;">
			<h5 class="card-title fs-6">${param.title}</h5>
			<p class="card-text" style="font-size: 12px;">${param.des}</p>

		</div>
		<div class="mb-3 text-center">
			<span class=" fs-7">${param.views }<i
				class="far fa-eye ms-1 me-3"></i>${param.like}<i style="color: red;"
				class="ms-1 bi bi-heart-fill"></i></span>
		</div>
	</div>
</div>

<!-- End Item -->