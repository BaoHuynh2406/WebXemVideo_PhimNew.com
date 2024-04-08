<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fm" %>

      <div class="container-fluid " style="margin-top: 100px;">
        <div class="row">
          <div class="col-12" id="nc1">
            <div class="video-container">
              <iframe style="border: 1px solid black; border-radius: 12px;" width="100%" height="550px" src="{{url}}"
                title="YouTube video player" frameborder="0"
                allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
            </div>
            <div class="mt-3">
              <div class="d-flex justify-content-between">
                <div>
                  <h2>{{video.title}}</h2>

                </div>
                <div class="flex-direction-end">
                    <button type="submit" class="btn-like btn nut mx-2" ng-click="toggleLike()">
                      <i ng-class="{'bi bi-heart': !isLiked, 'bi bi-heart-fill': isLiked}"
                        style="color: {{isLiked ? 'red' : 'black'}}"></i> {{likeNum}}
                    </button>
                    <button class="share-btn btn nut "><i style="color: rgb(10, 36, 152);" class="fas fa-share-alt"></i>
                      Chia sẻ</button>
                </div>
              </div>
              <div class="col-12">
                <hr>
                <div class="col-12 p-2" style="border-radius: 10px; background-color: #ededed;">
                  <span class="mb-1 fw-bold" style="font-size: 14px; color:#333;">{{video.views}} lượt xem - 2 ngày
                    trước</span>
                  <p>{{video.des}}</p>
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

        </div>
      </div>