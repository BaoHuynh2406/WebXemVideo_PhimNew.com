<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fm" %>
    
<section class="home-section" style="height: 600px;" >
    <div id="carouselExampleCaptions" class="carousel slide h-100">
        <div class="carousel-indicators">
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner h-100">
          <div class="carousel-item active">
            <img src="views/src/img/2-1-06204547.jpg" class="d-block w-100" alt="...">
            <div class="carousel-caption d-none d-md-block">
              <h5>Kungfu Panda</h5>
              <p>Xem ngày 23/3 sale off 50%.</p>
            </div>
          </div>
          <a href="" class="carousel-item h-100">
            <img  src="views/src/img/4629787_cover_endgamex-1.jpg" class="d-block w-100" alt="...">
            <div class="carousel-caption d-none d-md-block">
              <h5>End Game</h5>
              <p>Top 1 trending in USA.</p>
            </div>
          </a>
          <div class="carousel-item h-100">
            <img src="views/src/img/mai.jpg" class="d-block w-100" alt="...">
            <div class="carousel-caption d-none d-md-block">
              <h5>Mai</h5>
              <p>Top 1 trending in Việt Nam</p>
            </div>
          </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Next</span>
        </button>
      </div>
</section>


<!-- Block Video -->
<section class="home-section">

    <div class="container">
        <!-- Tiêu đề -->
        <h4 class="fw-bold mb-3" style="color: #1e54a4;">Dành cho bạn</h4>
        <ul class="tabs-control select">
            <li class="selection">Trending</li>
            <li>Yêu thích</li>
            <li>Đã xem</li>
        </ul>
        <!-- Nội dung -->
		<div class="row Block px-3 justify-content-between">
				<c:forEach var="v" items="${LIST_VIDEO}">
					<jsp:include page="/views/layout/item_video.jsp">
						<jsp:param value="${v.title}" name="title" />
						<jsp:param value="${v.des}" name="des" />
						<jsp:param value="${v.photo}" name="img" />
						<jsp:param value="${v.url}" name="url" />
						<jsp:param value="${v.views}" name="views" />
						<jsp:param value="${v.likes}" name="like" />
					</jsp:include>
				</c:forEach>
		</div>
	</div>
</section>
<!-- End Block Khóa học -->