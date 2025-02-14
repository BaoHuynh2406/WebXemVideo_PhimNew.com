<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>

      <div>
        <section class="home-section" style="height: 600px;" ng-app="">
          <div id="carouselExampleCaptions" class="carousel slide h-100">
            <div class="carousel-indicators">
              <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active"
                aria-current="true" aria-label="Slide 1"></button>
              <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1"
                aria-label="Slide 2"></button>
              <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2"
                aria-label="Slide 3"></button>
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
                <img src="views/src/img/4629787_cover_endgamex-1.jpg" class="d-block w-100" alt="...">
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
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions"
              data-bs-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions"
              data-bs-slide="next">
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
              <li ng-click="loadItems('made_for_you')" ng-class="{ 'selection': selectedTab === 'made_for_you' }">Made
                For
                you</li>
              <li ng-click="loadItems('yeu_thich')" ng-class="{ 'selection': selectedTab === 'yeu_thich' }">Yêu thích
              </li>
              <li ng-click="loadItems('da_xem')" ng-class="{ 'selection': selectedTab === 'da_xem' }">Đã xem</li>
            </ul>
            <!-- Nội dung -->
            <div class="py-4"
              style="box-shadow: 0 0 15px rgba(10, 10, 10, 0.2); border-radius: 20px; background-color: #f7f7f7;">
              <div class="row m-0 Block justify-content-between">

                <!-- Item -->
                <a href="#!/watch?id={{v.Id}}" class="col-sm-12 col-md-6 col-lg-4 mb-5" ng-repeat="v in videos">
                  <div class="card card-custom l-bg-cherry px-0">
                    <img src="views/src/img/{{v.poster}}" class="card-img-top" alt="..." style="height: 100%;">
                    <div class="card-body">
                      <h5 class="card-title fs-5 mb-2">{{v.title}}</h5>
                      <div class="mb-1">
                        <span class="fs-7">Lượt xem: {{v.views | number}}
                        </span>
                      </div>
                    </div>
                  </div>
                </a>

              </div>

            </div>
          </div>
        </section>


        <!-- Block Trending -->
        <section class="home-section">

          <div class="container">
            <!-- Tiêu đề -->
            <h4 class="fw-bold mb-3" style="color: #1e54a4;">Trending</h4>
            <ul class="tabs-control select">
              <li ng-click="loadItemsTrend('nhieu_luot_xem')"
                ng-class="{ 'selection': selectedTabTrend === 'nhieu_luot_xem' }">Nhiều lượt xem</li>
              <li ng-click="loadItemsTrend('hot_trong_tuan')"
                ng-class="{ 'selection': selectedTabTrend === 'hot_trong_tuan' }">Hot trong tuần</li>
            </ul>
            <!-- Nội dung -->
            <div class="py-4"
              style="box-shadow: 0 0 15px rgba(10, 10, 10, 0.2); border-radius: 20px; background-color: #f7f7f7;">
              <div class="row m-0 Block justify-content-between">


                <!-- Item -->
                <a href="#!/watch?id={{v.Id}}" class="col-sm-12 col-md-6 col-lg-4 mb-5" ng-repeat="v in videos2">
                  <div class="card card-custom l-bg-cherry px-0">
                    <img src="views/src/img/{{v.poster}}" class="card-img-top" alt="..." style="height: 100%;">
                    <div class="card-body">
                      <h5 class="card-title fs-5 mb-2">{{v.title}}</h5>
                      <div class="mb-1">
                        <span class="fs-7">Lượt xem: {{v.views | number}}</span>
                      </div>
                    </div>
                  </div>
                </a>


              </div>

            </div>
          </div>
        </section>

      </div>