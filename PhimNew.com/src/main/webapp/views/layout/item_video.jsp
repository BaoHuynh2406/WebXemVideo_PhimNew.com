<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<c:if test="${param.active eq true}">
    <!-- Item -->
    <a href="./video?id=${param.title }" class="col-sm-12 col-md-6 col-lg-4 mb-5">
        <div class="card card-custom l-bg-cherry px-0">
            <img src="views/src/img/${param.img}" class="card-img-top" alt="..." style="height: 100%;">
            <div class="card-body" >
                <h5 class="card-title fs-5 mb-2">${param.title}</h5>
				<div class="mb-1">
					<span class=" fs-7">${param.views }<i class="far fa-eye ms-1 me-3"></i>${param.like}<i style="color: red;" class="ms-1 bi bi-heart-fill"></i></span>
				</div>
            </div>
           
        </div>
    </a>
    <!-- End Item -->
</c:if>