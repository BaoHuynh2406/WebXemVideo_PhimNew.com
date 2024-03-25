<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<section class="home-section" style="height: 600px;" ng-controller="myCtrl">
    <div id="carouselExampleCaptions" class="carousel slide h-100">
        <div class="carousel-indicators">
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
          <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner h-100">
          <div class="carousel-item active">
            <img src="src/img/2-1-06204547.jpg" class="d-block w-100" alt="...">
            <div class="carousel-caption d-none d-md-block">
              <h5>First slide label</h5>
              <p>Some representative placeholder content for the first slide.</p>
            </div>
          </div>
          <div class="carousel-item h-100">
            <img src="src/img/4629787_cover_endgamex-1.jpg" class="d-block w-100" alt="...">
            <div class="carousel-caption d-none d-md-block">
              <h5>Second slide label</h5>
              <p>Some representative placeholder content for the second slide.</p>
            </div>
          </div>
          <div class="carousel-item h-100">
            <img src="src/img/mai.jpg" class="d-block w-100" alt="...">
            <div class="carousel-caption d-none d-md-block">
              <h5>Third slide label</h5>
              <p>Some representative placeholder content for the third slide.</p>
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

           <jsp:include page="layout/item_video.jsp"></jsp:include>





        </div>
    </div>
</section>
<!-- End Block Khóa học -->