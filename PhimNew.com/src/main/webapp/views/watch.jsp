<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fm" %>

      <!DOCTYPE html>
      <html lang="en">

      <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Watch</title>

        <link rel="icon" type="image/x-icon" href="views/src/img/logo12.png">
        <!-- Bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css" />
        <!-- Google Fonts Roboto -->
        <link rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" />
        <!-- CSS -->
        <link rel="stylesheet" href="views/src/css/home-page.css">

        <!-- Angular JS-->
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js"></script>
        <!-- AngularJS Route -->
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular-route.min.js"></script>


      </head>

      <body>
        <!-- Header -->
        <header class="header p-3 mb-1 border-bottom " id="header">
          <%@include file="layout/header.jsp" %>
        </header>



        <div class="container-fluid " style="margin-top: 100px;">
          <div class="row">
            <div class="col-9" id="nc1">
              <div class="video-container">
                <iframe style="border: 1px solid black; border-radius: 12px;" width="100%" height="550px"
                  src="https://www.youtube.com/embed/${v.url}" title="YouTube video player" frameborder="0"
                  allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                  referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
              </div>
              <div class="mt-3">
                <div class="d-flex justify-content-between">
                  <div>
                    <h2>${v.title}</h2>
                    <button style="font-size: 14px; color:#333; font-style: italic;" class="btn"><i
                        class="bi bi-eye-fill"></i>${v.views}</button>
                  </div>
                  <div class="flex-direction-end">
                    <button class="share-btn btn nut  mx-2"><i style="color: red" class="bi bi-heart-fill"></i> 100
                    </button>
                    <button class="share-btn btn nut "><i style="color: rgb(10, 36, 152);" class="fas fa-share-alt"></i>
                      Chia sẻ</button>
                  </div>
                </div>
                <div class="col-12">
                  <hr>
                  <div class="col-12 " style="border-radius: 10px; background-color: #ededed;">
                    <p style="padding: 18px;">${v.des}</p>
                  </div>
                </div>
                <div class="binhluan p-3">
                  <div class="comment-box">
                    <div class="fs-3 fw-bold">Bình luận</div>
                    <div class="mb-3">
                      <label for="exampleFormControlTextarea1" class="form-label">User</label>
                      <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
                    </div>
                    <button type="submit" class="btn btn-primary">Gửi</button>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-3">
              <div class="card row" style="height: 100px; border-radius: 10px;">
                <img class="col-5" style="width: 100px; height: 100px;" src="" alt="hình">
                <div class="col-7">
                  <h2>Mai</h2>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- Footer -->
        <footer class="text-center text-lg-start text-white" style="background-color: #1c2331">
          <%@include file="layout/footer.jsp" %>

        </footer>

      </body>

      </html>